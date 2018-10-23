package com.highlig_spring4.ch3.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类
 *
 * @author changzhenzhen
 * @date 2018-10-22
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }
}
