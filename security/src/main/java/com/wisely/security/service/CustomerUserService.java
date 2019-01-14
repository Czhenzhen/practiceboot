package com.wisely.security.service;

import com.wisely.security.dao.SysUserRepository;
import com.wisely.security.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
  * 自定义UserDetailService
  *
  * @author  changzhenzhen
  * @date 2019-01-09
  */
//自定义需实现UserDetailsService接口
public class CustomerUserService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;

    //重写此方法获得用户
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByUsername(s);
        if (null == user){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //实现了UserDetails接口，可直接返给Spring security使用
        return user;
    }
}
