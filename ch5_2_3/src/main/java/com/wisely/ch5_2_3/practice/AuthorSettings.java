package com.wisely.ch5_2_3.practice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
  * 类型安全，基于properties
  *
  * @author  changzhenzhen
  * @date 2018-11-05
  */
@Component
@ConfigurationProperties(prefix = "author")
//资源文件的位置
@PropertySource("classpath:config/author.properties")
public class AuthorSettings {

    private String name;

    private Long age;

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
    public Long getAge() {
        return age;
    }

    /**
     * 属性set方法
     */
    public void setAge(Long age) {
        this.age = age;
    }
}
