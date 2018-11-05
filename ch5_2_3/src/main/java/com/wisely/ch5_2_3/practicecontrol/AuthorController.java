package com.wisely.ch5_2_3.practicecontrol;

import com.wisely.ch5_2_3.practice.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * 测试自定义配置
  *
  * @author  changzhenzhen
  * @date 2018-11-05
  */
@RestController
public class AuthorController {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/author")
    public String index(){
        return "authorName is:"+authorSettings.getName()+",authorAge is:"+authorSettings.getAge();
    }
}
