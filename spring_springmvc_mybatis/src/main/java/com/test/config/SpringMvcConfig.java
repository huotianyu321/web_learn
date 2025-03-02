package com.test.config;

import com.test.controller.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.test.controller")
/*有特别多作用*/
@EnableWebMvc
/*继承WebMvcConfigurer可以添加过滤器和拦截器*/
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;

    /*拦截器*/
    public void addInterceptors(InterceptorRegistry registry) {
        /*对books路径下的任意路径的访问都会拦截*/
        registry.addInterceptor(myInterceptor).addPathPatterns("/users/**");
        // registry.addInterceptor(myInterceptor).addPathPatterns("/users/*");
        // registry.addInterceptor(myInterceptor).addPathPatterns("/users/*/*");
    }

    /*过滤器, 通常用于处理静态资源，告诉Spring MVC如何处理对静态资源的访问(而不是走控制器那套)*/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*注册一个资源处理器，它会处理所有以 "/pages/" 开头的请求。 可以注册多个*/

        /*这种方式，在传统web项目里，会从webapp这个根目录下去找*/
        registry.addResourceHandler("/static/**") // 匹配所有以 "/pages/" 开头的路径
                .addResourceLocations("/static/"); // 指定资源在类路径中的位置

        /*这种方式，会从resources文件夹下去找*/
        /*classpath:前缀用于告诉Spring从类路径（Classpath）中查找资源。这通常适用于那些打包在JAR文件中的资源或位于src/main/resources目录下的资源。*/
        registry.addResourceHandler("/static/**") // 匹配所有以 "/static/" 开头的路径
                .addResourceLocations("classpath:/static/"); // 指定资源在类路径中的位置
    }

}
