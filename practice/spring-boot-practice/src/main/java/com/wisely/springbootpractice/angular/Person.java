package com.wisely.springbootpractice.angular;
/**
  * 传值对象javaBean
  *
  * @author  changzhenzhen
  * @date 2018-11-19
  */
public class Person {

    private String name;

    private Integer age;

    private String address;

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    /**
     * 属性get方法
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 属性set方法
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 属性get方法
     */
    public String getAddress() {
        return address;
    }

    /**
     * 属性set方法
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
