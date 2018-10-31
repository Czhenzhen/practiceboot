package com.wisely.highlight_springmvc4.web.ch4_4;


import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * 演示控制器
  *
  * @author  changzhenzhen
  * @date 2018-10-30
  */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg")String msg, DemoObj obj){
        throw new IllegalArgumentException("抱歉，参数有误/。。。。。"+msg);
    }
}
