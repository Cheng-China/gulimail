package com.atguigu.gulimall.product.config;

import com.atguigu.gulimall.product.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(BaseException.class)
    public void handleBaseException(BaseException baseException){
        logger.info("code:{},message:{}",baseException.getCode(), baseException.getMessage());
    }
}
