package com.wisely.highlight_springmvc4.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
  * 服务器推送技术SEE（server send event）
  *
 * 当客户端向服务端发送请求，服务端会抓住这个请求不放，
 * 等有数据更新时才返回给客户端，
 * 当客户端接收消息后，再向服务器发送请求周而复始。
  * @author  changzhenzhen
  * @date 2018-11-01
  */
@Controller
public class SseController {

    //这里使用的媒体类型为text/event-stream,只是服务器端sse的支持
    @RequestMapping(value = "/push",produces = "text/event-stream")
    public @ResponseBody String push(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "data:Testing 1,2,3,"+r.nextInt()+"\n\n";
    }
}
