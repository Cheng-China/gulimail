package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author cheng
 * @email 481193684@qq.com
 * @date 2023-10-30 15:42:53
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
