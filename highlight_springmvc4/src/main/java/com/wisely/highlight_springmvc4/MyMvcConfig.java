package com.wisely.highlight_springmvc4;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;
import com.wisely.highlight_springmvc4.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

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
@EnableScheduling//计划任务
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

    /**
     * 设置路径转向页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("converter");
        registry.addViewController("/sse").setViewName("sse");
        registry.addViewController("/async").setViewName("async");
    }

    /**
     * 重写该方法可使url的"."后边的参数不被忽略
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }

    /**
    * 设置上传相关配置
     * @return  
     * @author  changzhenzhen
     * date 2018-10-31 
     **/
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        multipartResolver.setMaxInMemorySize(1000000);
        return multipartResolver;
    }


    /**
     * configureMessageConverter:重载会覆盖掉spring MVC默认注册的多个HttpMessageConverter
     * extendsMessageConverters：仅添加一个自定义的HttpMessageConverter，不覆盖默认注册的HttpMessageConverters；
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Bean
    public MyMessageConverter converter(){
        return new MyMessageConverter();
    }
}
