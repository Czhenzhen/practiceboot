package com.highlig_spring4.ch3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 示例组合注解
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//组合@Configuration元注解
@Configuration
//组合@ComponentScan元注解
@ComponentScan
public @interface WiselyConfiguration {

    //自定义注解，覆盖Value参数
    String[] value() default {};

}
