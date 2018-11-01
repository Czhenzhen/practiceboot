package com.wisely.highlight_springmvc4.web.ch4_5;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 演示控制器
 *
 * @author changzhenzhen
 * @date 2018-10-31
 */
@Controller
public class ConverterController {

    //指定返回的媒体类型为自定义的媒体类型
    @RequestMapping(value = "/convert",produces = {"application/x-wisely"},method = RequestMethod.POST)
    @ResponseBody
    public DemoObj converter(@RequestBody DemoObj demoObj) {
        return demoObj;

    }
}
