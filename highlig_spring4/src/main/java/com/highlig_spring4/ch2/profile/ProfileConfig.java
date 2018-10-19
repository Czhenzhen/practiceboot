package com.highlig_spring4.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * profile配置
 * profile为在不同环境下使用不同的配置提供了支持
 *
 * @author changzhenzhen
 * @date 2018-10-17
 */
@Configuration
@ComponentScan("com.highlig_spring4.ch2.profile")
public class ProfileConfig {

    //Profile为dev时实例化devDemoBean
    @Bean
    @Profile("dev")
    public DemoBean devDemoBean(){
        return new DemoBean("from development profile");
    }

    //Profile为prod时实例化prodDemoBean
    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }
}
