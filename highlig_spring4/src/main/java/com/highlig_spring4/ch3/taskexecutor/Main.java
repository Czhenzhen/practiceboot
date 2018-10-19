package com.highlig_spring4.ch3.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类
 * Spring通过任务执行器(TaskExecutor)来实现多线程和并发编程。
 * 使用ThreadpoolTaskExecutor可实现一个基于线程池的TaskExecutor。
 * 而实际开发中任务一般是非阻碍的，即异步的，所以我们要在配置类中通过@EnableAsync开启对异步任务的支持，
 * 并通过在实际执行的Bean的方法中使用@Async注解来声明其是一个异步任务
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AysncTaskService aysncTaskService = context.getBean(AysncTaskService.class);
        for (int i = 0; i < 20; i++) {
            aysncTaskService.executeAsyncTask(i);
            aysncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
