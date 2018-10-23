package com.highlig_spring4.ch3.annotation;

import org.springframework.stereotype.Service;

/**
 * 演示服务Bean
 *
 * @author changzhenzhen
 * @date 2018-10-22
 */
@Service
public class DemoService {

    public void outputResult(){
        System.out.println("从组合注解照样获得的bean");
    }
}
