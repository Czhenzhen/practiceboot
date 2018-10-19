package com.highlig_spring4.ch2.diconfig;

import org.springframework.stereotype.Service;

/**
 * //TODO 添加类/接口功能描述
 *
 * @author changzhenzhen
 * @date 2018-09-29
 */
//使用@service注解声明当前FunctionService类是Spring管理的一个Bean。
// 其中，使用@ComPonent、@Service、@Repository、@Controller是等效的，可根据需要选用
@Service
public class FunctionService {

    public String sayHelloWorld(String word) {
        return "Hello" + word + "!";
    }

}
