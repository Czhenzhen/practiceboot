package com.wisely.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 角色
 *
 * @author changzhenzhen
 * @date 2019-01-08
 */
@Entity
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;

    //角色名称
    private String name;

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
