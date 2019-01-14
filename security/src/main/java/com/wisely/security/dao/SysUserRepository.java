package com.wisely.security.dao;

import com.wisely.security.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  * 数据访问
  *
  * @author  作者信息
  * @date 2019-01-09
  */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String username);
}
