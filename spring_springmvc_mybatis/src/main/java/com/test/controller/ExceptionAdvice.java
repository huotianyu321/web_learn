package com.test.controller;

import com.test.controller.common.ApiResult;
import com.test.controller.common.AppException;
import com.test.controller.common.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*通过aop进行全局抛出的异常处理*/
@RestControllerAdvice
public class ExceptionAdvice {
    /*@ExceptionHandler注解！！*/
    @ExceptionHandler(value = AppException.class)
    public ApiResult<String> handleException(AppException e) {
        return new ApiResult<String>(e.getCode(), e.getMessage(), null);
    }
}
