package com.wisely.springbootpractice.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
  * 配置viewController发是测是ggg
  *
  * @author  changzhenzhen
  * @date 2018-11-13
  */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws").setViewName("websocket/ws");
        registry.addViewController("/login").setViewName("websocket/login");//跳转至登录页面
        registry.addViewController("/chat").setViewName("websocket/chat");//跳转至聊天页面
    }
}
