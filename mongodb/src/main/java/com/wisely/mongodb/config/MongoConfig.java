package com.wisely.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
  * 配置开启Mongo支持
  *
  * @author  changzhenzhen
  * @date 2019-01-07
  */
@Configuration
@EnableMongoRepositories
public class MongoConfig {
}
