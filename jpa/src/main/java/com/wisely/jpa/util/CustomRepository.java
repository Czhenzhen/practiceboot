package com.wisely.jpa.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
  * 自定义
  *
  * @author  作者信息
  * @date 2018-12-28
  */
//项目初始化时实体类不会实例化
@NoRepositoryBean
//JpaSpecificationExecutor 具备使用Specification的能力：动态查询
public interface CustomRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,
        JpaSpecificationExecutor<T> {

    Page<T> findByAuto(T example, Pageable pageable);

}
