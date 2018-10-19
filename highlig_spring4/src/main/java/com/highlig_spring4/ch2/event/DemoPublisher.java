package com.highlig_spring4.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * (3)、事件发布类
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
@Component
public class DemoPublisher {

    //注入ApplicationContext用来发布事件
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg){
        //使用ApplicationContext的publishEvent方法来发布
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}
