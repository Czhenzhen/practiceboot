package com.wisely.springbootpractice.angular;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * 控制器
 *
 * @author changzhenzhen
 * @date 2018-11-19
 */
@RestController
public class AngularController {

    @RequestMapping(value = "/search",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName){
        return new Person(personName,12,"hefei");
    }

}
