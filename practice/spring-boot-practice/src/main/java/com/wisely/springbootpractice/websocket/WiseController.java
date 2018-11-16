package com.wisely.springbootpractice.websocket;

import com.wisely.springbootpractice.websocket.broadcast.WiselyMessage;
import com.wisely.springbootpractice.websocket.broadcast.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 控制类
 *
 * @author changzhenzhen
 * @date 2018-11-13
 */
@Controller
public class WiseController {


     // 通过SimpMessagingTemplate向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


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

    @MessageMapping("/chat")
    //在SpringMVC可以直接在参数中获取principal，principal中包含当前用户的信息
    public void handleChat(Principal principal,String msg){
        //给对方发送消息
        if (principal.getName().equals("czz")){
            messagingTemplate.convertAndSendToUser("mfl","/queue/notifications",principal.getName()+"-send:"+msg);
        }else {
            messagingTemplate.convertAndSendToUser("czz","/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }

}
