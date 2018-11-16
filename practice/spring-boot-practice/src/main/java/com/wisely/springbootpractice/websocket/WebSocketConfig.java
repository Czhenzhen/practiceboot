package com.wisely.springbootpractice.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
  * websocket配置类
 * 广播式：即服务端有消息时，会将消息发送给所有连接了当前endpoint的浏览器
  *
  * @author  changzhenzhen
  * @date 2018-11-13
  */
@Configuration
//通过@EnableWebSocketMessageBroker注解开启使用stomp协议来传输基于代理（message broker）的消息，
// 这时控制器支持使用@MessageMapping,就像使用@RequestMapping一样
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 注册STOMP的协议节点（endponit），并映射指定的url
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个STOMP的endpoint，并指定使用SocketJS协议
        registry.addEndpoint("/endpointWisely").withSockJS();
        //注册一个名为/endpointChat的endpoint
        registry.addEndpoint("/endpointChat").withSockJS();
    }

    /**
     * 配置消息代理Message Broker
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式应配置一个/topic消息代理
        registry.enableSimpleBroker("/topic");
        //点对点式增加一个/queue消息代理
        registry.enableSimpleBroker("/queue","/topic");
    }



}
