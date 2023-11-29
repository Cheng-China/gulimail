package com.atguigu.gulimall.order.feign;

import com.atguigu.gulimall.common.utils.R;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MemberClientTest {

    @Resource
    MemberClinet memberClinet;

    @Test
    public void testList(){
        R list = memberClinet.info(1L);
        System.out.println(list);
    }
}
