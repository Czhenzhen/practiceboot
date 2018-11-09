package com.wisely.springbootpractice.control;


import com.wisely.springbootstarterhello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * 测试自定义配置
  *
  * @author  changzhenzhen
  * @date 2018-11-06
  */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String index(){
       return helloService.sayHello();
    }

}
