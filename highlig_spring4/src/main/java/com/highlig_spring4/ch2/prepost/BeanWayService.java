package com.highlig_spring4.ch2.prepost;

/**
 * 使用@Bean形式的Bean
 *
 * @author changzhenzhen
 * @date 2018-10-09
 */
public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService() {
        super();
        System.out.println("初始化构造函数-BeanWayService");
    }

    public void destory(){
        System.out.println("@Bean-destory-method");
    }
}
