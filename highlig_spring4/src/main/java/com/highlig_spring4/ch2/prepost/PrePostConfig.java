package com.highlig_spring4.ch2.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author changzhenzhen
 * @date 2018-10-17
 */
@Configuration
@ComponentScan("com.highlig_spring4.ch2.prepost")
public class PrePostConfig {

    //initMethod和destoryMethod指定BeanWayService类的init和destory方法在构造函数之后、bean销毁之后执行
    @Bean(initMethod = "init",destroyMethod = "destory")
     BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}
