package com.highlig_spring4.ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类（条件注解@Conditional）
 *
 * 不同的操作系统，通过实现Condition接口，
 * 并重写matches方法构造判断条件
 *
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
public class Main {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+"系统下的列表命令为："+listService.showListCmd());
    }
}
