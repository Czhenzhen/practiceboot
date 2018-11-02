package com.wisely.highlight_springmvc4.web.ch4_5;

import com.wisely.highlight_springmvc4.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
  * 演示servlet3.0+异步处理方法控制器
  *
  * @author  changzhenzhen
  * @date 2018-11-01
  */
@Controller
public class AysncController {

    @Autowired
    private PushService pushService;

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall(){
        return pushService.getAsyncUpdate();
    }
}
