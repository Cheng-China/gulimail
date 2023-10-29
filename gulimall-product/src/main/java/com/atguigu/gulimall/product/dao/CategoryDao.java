package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author cheng
 * @email 481193684@qq.com
 * @date 2023-10-29 13:23:16
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
