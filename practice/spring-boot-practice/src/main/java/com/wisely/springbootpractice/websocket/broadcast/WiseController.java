package com.wisely.springbootpractice.websocket.broadcast;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * 控制类
 *
 * @author changzhenzhen
 * @date 2018-11-13
 */
@Controller
public class WiseController {


    //当浏览器向服务端发送请求时，
    // 通过@MessageMapping映射到/welcome这个地址，
    // 类似于@ResquestMapping
    @MessageMapping("/welcome")
    //当服务器有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception {
        //Thread.sleep(3000);
        return new WiselyResponse("Welcome,"+message.getName()+"!");
    }

}
