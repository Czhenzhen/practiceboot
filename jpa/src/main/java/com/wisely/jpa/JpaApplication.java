package com.wisely.jpa;

import com.wisely.jpa.dao.PersonRepository;
import com.wisely.jpa.util.CustomReposiitoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomReposiitoryFactoryBean.CustomRepositoryFactory.class)
public class JpaApplication {

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

}

