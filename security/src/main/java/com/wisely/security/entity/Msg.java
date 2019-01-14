package com.wisely.security.entity;
/**
  * 用来测试不同角色用户的数据展示
  *
  * @author  changzhenzhen
  * @date 2019-01-09
  */
public class Msg {

    private String title;

    private String content;

    private String etraInfo;

    public Msg(String title, String content, String etraInfo) {
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }


    /**
     * 属性get方法
     */
    public String getTitle() {
        return title;
    }

    /**
     * 属性set方法
     */
    public void setTitle(String title) {
        this.title = title;
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

    /**
     * 属性get方法
     */
    public String getEtraInfo() {
        return etraInfo;
    }

    /**
     * 属性set方法
     */
    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
