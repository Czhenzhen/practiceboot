package com.highlig_spring4.ch2.profile;

/**
 * bean
 *
 * @author changzhenzhen
 * @date 2018-10-17
 */
public class DemoBean {
    public String content;

    public DemoBean(String content) {
        super();
        this.content = content;
    }

    /**
     * 属性get方法
     */
    public String getContent() {
        return content;
    }

    /**
     * 属性set方法
     */
    public void setContent(String content) {
        this.content = content;
    }
}
