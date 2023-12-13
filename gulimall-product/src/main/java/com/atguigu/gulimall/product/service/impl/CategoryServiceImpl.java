package com.atguigu.gulimall.product.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.Query;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        List<CategoryEntity> rootCategory = categoryEntities
                .stream()
                .filter(item -> item.getParentCid() == 0)
                .sorted(Comparator.comparing(CategoryEntity::getSort))
                .collect(Collectors.toList());

        rootCategory.forEach(item -> setChildren(item, categoryEntities));
        return rootCategory;
    }

    public void setChildren(CategoryEntity root, List<CategoryEntity> categoryEntities){
        categoryEntities.stream()
                .filter(item -> Objects.equals(item.getParentCid(), root.getCatId()))
                .peek(item -> {
                    if (ObjectUtil.isNull(root.getChildren())){
                        root.setChildren(new ArrayList<>());
                    }
                    root.getChildren().add(item);
                })
//                .sorted(Comparator.comparing(CategoryEntity::getSort))
                .forEach(item -> setChildren(item,categoryEntities));
    }

}