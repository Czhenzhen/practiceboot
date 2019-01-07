package com.wisely.jpa.util.impl;

import com.wisely.jpa.util.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;


import static com.wisely.jpa.util.CustomerSpecs.*;

/**
  * 自定义到实现
  *
  * @author  changzhenzhen
  * @date 2018-12-28
  */
public class CustomRepositoryImpl<T,ID extends Serializable>
        extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass,EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    //使用byAuto Specification构造的条件查询，并提供分页功能
    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager,example),pageable);
    }
}
