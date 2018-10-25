package com.wisely.highlight_springmvc4.domain;
/**
  * 用来获取request对象参数和返回此对象到response
  *
  * @author  changzhenzhen
  * @date 2018-10-25
  */
public class DemoObj {

    private Long id;

    private String name;

    //jackson对对象和json做转换时一定需要此空构造
    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 属性get方法
     */
    public Long getId() {
        return id;
    }

    /**
     * 属性set方法
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 属性get方法
     */
    public String getName() {
        return name;
    }

    /**
     * 属性set方法
     */
    public void setName(String name) {
        this.name = name;
    }
}
