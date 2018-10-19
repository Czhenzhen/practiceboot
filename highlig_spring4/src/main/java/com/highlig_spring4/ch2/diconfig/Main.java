package com.highlig_spring4.ch2.diconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * //TODO 添加类/接口功能描述
 *
 * @author changzhenzhen
 * @date 2018-09-29
 */
public class Main {
    public static void main(String[] args) {
        //使用AnnotationConfigApplicationContext作为Spring容器，接收一个配置类作为参数
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        //获得声明配置的UseFunctionService的Bean
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("hello world"));
        context.close();
    }
}
