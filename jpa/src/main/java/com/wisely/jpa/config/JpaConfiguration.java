package com.wisely.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
  * 配置jpa
  *
  * @author  changzhenzhen
  * @date 2018-12-26
  */
@Configuration
@EnableJpaRepositories("com.wisely.jpa")
public class JpaConfiguration {

}
