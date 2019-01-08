package com.wisely.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.annotation.Generated;
import java.util.Collection;
import java.util.LinkedHashSet;


/**
  * 实体类
  *采用正向工程通过实体类生成表结构
  * @author  changzhenzhen
  * @date 2018-12-26
  */
//此注解映射领域模型和MongoDB的文档
@Document
public class Person {

    @Id//@Id指明这个属性映射为文档的主键
    private String id;

    private String name;

    private Integer age;

    //@Field 注解此属性在文档中的名称为locs，location属性将以数组形式存在当前数据记录中
    @Field("locs")
    private Collection<Location> locations = new LinkedHashSet<Location>();

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * 属性get方法
     */
    public String getId() {
        return id;
    }

    /**
     * 属性set方法
     */
    public void setId(String id) {
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
    public Collection<Location> getLocations() {
        return locations;
    }

    /**
     * 属性set方法
     */
    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
}
