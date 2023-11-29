package com.atguigu.gulimall.order.feign;

import com.atguigu.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-member")
public interface MemberClinet {
    @RequestMapping("member/member/info/{id}")
    R info(@PathVariable("id") Long id);
}
