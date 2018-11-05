package com.wisely.ch5_2_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch523Application {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Ch523Application.class);
        //app.setBannerMode(Banner.Mode.OFF);//关闭banner
        app.run(args);
    }
}
