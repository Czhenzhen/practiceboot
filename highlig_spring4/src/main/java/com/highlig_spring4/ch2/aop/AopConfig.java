package com.highlig_spring4.ch2.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
  * 配置类
  *
  * @author  changzhenzhen
  * @date 2018-09-30
  */
@Configuration
@ComponentScan("com.highlig_spring4.ch2.aop")
//使用@EnableAspectJAutoPrixy注解开启Spring对AspectJ的支持
@EnableAspectJAutoProxy
public class AopConfig {
}
