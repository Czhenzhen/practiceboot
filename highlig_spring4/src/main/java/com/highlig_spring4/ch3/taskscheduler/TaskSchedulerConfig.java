package com.highlig_spring4.ch3.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 配置类
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */

@Configuration
@ComponentScan("com.highlig_spring4.ch3.taskscheduler")
//使用@EnableScheduling注解开启对计划任务的支持
@EnableScheduling
public class TaskSchedulerConfig {

}
