package com.highlig_spring4.ch3.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
@Configuration
public class ConditionConfig {

    @Bean
    //通过@Conditional注解，符合Windows条件则实例化windowslistService
    @Conditional(WindowCondition.class)
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    //通过@Conditional注解，符合Linux条件则实例化linuxListService
    @Conditional(LinuxCondition.class)
    public ListService linuxListService(){
        return new LinuxListService();
    }
}
