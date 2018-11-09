package com.wisely.springbootpractice;

import com.wisely.springbootstarterhello.HelloServiceAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//自定义的starter--配置文件
@ImportAutoConfiguration({HelloServiceAutoConfiguration.class})
@SpringBootApplication
public class SpringBootPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPracticeApplication.class, args);
    }
}
