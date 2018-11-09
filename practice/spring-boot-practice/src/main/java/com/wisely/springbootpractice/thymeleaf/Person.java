package com.wisely.springbootpractice.thymeleaf;

/**
 * 示例Bean
 *
 * @author changzhenzhen
 * @date 2018-11-09
 */
public class Person {

    private String name;

    private Integer age;

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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
}
