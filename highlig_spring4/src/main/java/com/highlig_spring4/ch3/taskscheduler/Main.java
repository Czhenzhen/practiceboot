package com.highlig_spring4.ch3.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
