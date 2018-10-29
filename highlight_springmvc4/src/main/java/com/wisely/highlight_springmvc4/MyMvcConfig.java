package com.wisely.highlight_springmvc4;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * spring MVC 配置
 *
 * @author changzhenzhen
 * @date 2018-10-24
 */
@Configuration
//@EbableWebMvc开启SpringMvc支持，若无此句，重写WebMvcConfigurerAdapter方法无效
@EnableWebMvc
@ComponentScan("com.wisely.highlight_springmvc4")
//继承WebMvcConfigurerAdapter类，重写其方法可对Spring MVC进行配置
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    //InternalResourceViewResolver作用是在controller返回的时候进行解析视图
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //prefix表示目录
        viewResolver.setPrefix("/WEB-INF/classes/view/");
        //suffix表示后缀
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceLocations指的是文件的放置的目录
        //addResourceHandler指的是对外暴露的目录
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }
}
