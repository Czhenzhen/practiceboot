package com.wisely.security.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户
 *
 * @author changzhenzhen
 * @date 2019-01-08
 */
@Entity
//实现UserDetails自定义用户实体即为Spring Security所使用的用户
public class SysUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    //配置用户和角色的多对多关系
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<SysRole> roles;

    //重写getAuthorities，将用户的角色作为权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority>  auths = new ArrayList<GrantedAuthority>();
        List<SysRole> roles = this.getRoles();
        for(SysRole role:roles){
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
     * 属性set方法
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 属性set方法
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 属性get方法
     */
    public List<SysRole> getRoles() {
        return roles;
    }

    /**
     * 属性set方法
     */
    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
