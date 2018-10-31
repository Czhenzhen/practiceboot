package com.wisely.highlight_springmvc4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 简单的控制器
 *
 * @author changzhenzhen
 * @date 2018-10-24
 */
//利用@Controller注解声明是一个控制器
@Controller
public class HelloController {

    //使用@RequestMapping配置url和方法之间对的映射
   /* @RequestMapping("/index")
    public String hello(){
        //通过ViewerResolver的Bean的配置，返回值为index，说明页面放置的路径为/WEB-INF/classes/views/index.jsp
        return "index";
    }*/
}
