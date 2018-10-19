package com.highlig_spring4.ch2.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用JSR250形式的Bean
 *
 * @author changzhenzhen
 * @date 2018-10-17
 */
public class JSR250WayService {

    //@PostContruct，在构造函数执行完之后执行
    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService() {
        super();
        System.out.println("初始化构造函数-JSR250WayService");
    }

    //@PreDestory，在Bean销毁之前执行
    @PreDestroy
    public void destory(){
        System.out.println("jsr250-destory-method");
    }

}
