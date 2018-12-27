package com.wisely.jpa.domain;

import javax.persistence.*;

/**
  * 实体类
  *采用正向工程通过实体类生成表结构
  * @author  changzhenzhen
  * @date 2018-12-26
  */

//@Entity注解指明这是一个和数据库表映射的实体类
@Entity
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
        query = "select p from Person p where p.name=?1 and p.address=?2")
public class Person {

    @Id//@Id指明这个属性映射为数据库的主键
    //此注解默认使用的主键自增，hibernate会自动生成一个名为hibernate_sequence的序列
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person() {
    }

    public Person(Long id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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
