package com.wisely.jpa.util;

import com.wisely.jpa.util.impl.CustomRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 定义repositoryFactoryBean
 * 可以作为模板使用
 *
 * @author changzhenzhen
 * @date 2018-12-28
 */
public class CustomReposiitoryFactoryBean<T extends JpaRepository<S, ID>, S,
        ID extends Serializable> extends JpaRepositoryFactoryBean<T,S,ID> {


    public CustomReposiitoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomRepositoryFactory(entityManager);
    }

    public static class CustomRepositoryFactory extends JpaRepositoryFactory{
        public CustomRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @SuppressWarnings({"unchecked"})
        protected <T,ID extends Serializable> SimpleJpaRepository<?,?>
            getTargetRepository1(RepositoryInformation information, EntityManager entityManager) {
            return new CustomRepositoryImpl<T,ID>((Class<T>) information.getDomainType(),entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return CustomRepositoryImpl.class;
        }
    }
}
