package com.wisely.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.wisely.mongodb.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbApplication {
    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Bean
    public MongoClient client() throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("127.0.0.1", 27017));
        return client;
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        String database = new MongoClientURI("mongodb://localhost/test").getDatabase();
        return new SimpleMongoDbFactory(client(),database);

    }
    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory)throws UnknownHostException{
        return new MongoTemplate(mongoDbFactory);
    }
}

