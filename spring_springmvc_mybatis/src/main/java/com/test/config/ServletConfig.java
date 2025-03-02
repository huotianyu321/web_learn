package com.test.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


/*
 * ServletConfig 类被称为 Web 项目的入口配置类，是因为它继承了 AbstractAnnotationConfigDispatcherServletInitializer。
 * 而 AbstractAnnotationConfigDispatcherServletInitializer 是 Spring MVC 提供的一个用于初始化 Web 应用的核心类。
 * 它的作用类似于传统的 web.xml 文件，但使用了基于 Java 的配置方式。
 * 具体作用:
 * 1. 替代web.xml文件（用于配置Servlet,Filter, Listener）
 * 2. 初始化Spring容器
 * AbstractAnnotationConfigDispatcherServletInitializer 会在 Web 应用启动时自动初始化
 * Spring 的根容器（Root ApplicationContext）和 Spring MVC 的 Servlet 容器（Servlet ApplicationContext）。
 * 根容器：通常用于配置服务层、数据层等非 Web 相关的 Bean。
 * Servlet 容器：通常用于配置控制器（Controller）、视图解析器（ViewResolver）、拦截器（Interceptor）等 Web 相关的 Bean。
 * 3. 配置Spring MVC的DispatcherServlet
 * DispatcherServlet 是 Spring MVC 的核心 Servlet，负责接收所有的 HTTP 请求并将其分发给相应的控制器。
 * AbstractAnnotationConfigDispatcherServletInitializer 会自动配置并注册 DispatcherServlet，同时指定它的映射路径（URL 模式）。
 */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*指定spring根容器配置类*/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /*指定Servlet容器的配置类*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /*返回DispatcherServlet 的 URL 映射路径，这里处理所有请求*/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*设置post请求中文乱码过滤器*/
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        return new Filter[]{filter};
    }
}
