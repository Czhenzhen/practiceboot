package com.highlig_spring4.ch3.taskexecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 配置类
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
@Configuration
@ComponentScan("com.highlig_spring4.ch3.taskexecutor")
//使用@EnableAsync注解开启异步任务的支持
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {

    //配置类实现AsyncConfigurer接口并重写getAsyncExecutor方法，
    // 并返回一个ThreadPoolTaskExecutor，
    // 这样就获得了一个基于线程池的TaskExecutor
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //corePoolSize：线程池的基本大小
        taskExecutor.setCorePoolSize(3);
        //线程池的最大容量
        taskExecutor.setMaxPoolSize(15);
        //阻塞到线程队列
        taskExecutor.setQueueCapacity(25);
        //初始化任务
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
