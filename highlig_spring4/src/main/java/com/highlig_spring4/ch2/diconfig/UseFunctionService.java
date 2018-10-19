package com.highlig_spring4.ch2.diconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * //TODO 添加类/接口功能描述
 *
 * @author changzhenzhen
 * @date 2018-09-29
 */
//使用@Service注解声明当前UseFunctionService类是Spring管理的一个Bean
@Service
public class UseFunctionService {

    //使用@Autowired将FunctionService的实体Bean注入到UseFunctionService中，
    //让UseFunctionService具备FunctionService的功能，
    // 此处使用JSR-330的@Inject注解或者JSR-250的@Resource是等效的
    @Autowired
    private FunctionService functionService;

    public String sayHello(String word) {
        return functionService.sayHelloWorld(word);
    }
}
