package com.highlig_spring4.ch2.event;

import org.springframework.context.ApplicationEvent;

/**
 * (1)、自定义事件
 * <p>
 * Spring的事件需要遵循如下流程：
 * 1、自定义事件，继承ApplicationEvent
 * 2、自定义事件监听器，实现ApplictionListener
 * 3、使用容器发布事件
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
public class DemoEvent extends ApplicationEvent {

    public String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    /**
     * 属性get方法
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 属性set方法
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
