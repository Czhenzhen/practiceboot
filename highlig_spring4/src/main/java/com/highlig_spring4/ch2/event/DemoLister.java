package com.highlig_spring4.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
  * (2)、事件监听器
  *
  * @author  changzhenzhen
  * @date 2018-10-18
  */
@Component
//实现ApplicationLister接口，并指定监听的事件类型
public class DemoLister implements ApplicationListener<DemoEvent> {

    @Override
    //使用onApplicationEvent方法对消息进行接收处理
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("bean-demoLister接收到了bean-publisher发布的消息："+msg);
    }
}
