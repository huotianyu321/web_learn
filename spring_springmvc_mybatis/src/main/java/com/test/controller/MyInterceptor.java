package com.test.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*拦截器类，执行具体的拦截操作*/
/*覆写三个方法*/
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    /*只有这个方法返回true时，后两个才会运行*/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("############preHandle");
        return true;
        // return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /*当controller处理请求返回异常时，这个不会运行，但下边的afterCompletion会运行*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("############postHandle");
        // HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("############afterCompletion");
        // HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
