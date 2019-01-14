package com.wisely.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
  * Spring MVC配置
  *
  * @author  changzhenzhen
  * @date 2019-01-09
  */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //注册访问/login转向login.htm页面
        registry.addViewController("/logss").setViewName("login11");
    }
}
