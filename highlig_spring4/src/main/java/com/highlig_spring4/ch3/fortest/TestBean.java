package com.highlig_spring4.ch3.fortest;
/**
  * 业务代码
  *
  * @author  changzhenzhen
  * @date 2018-10-23
  */
public class TestBean {
    private String content;

    public TestBean(String content) {
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
