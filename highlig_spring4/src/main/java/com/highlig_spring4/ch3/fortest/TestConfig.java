package com.highlig_spring4.ch3.fortest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 配置类
 *
 * @author changzhenzhen
 * @date 2018-10-23
 */

@Configuration
public class TestConfig {

    @Bean
    @Profile("dev")
    public TestBean devTest(){
        return new TestBean("dev");
    }

    @Bean
    @Profile("prod")
    public TestBean prodTest(){
        return new TestBean("prod");
    }
}
