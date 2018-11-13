package com.wisely.springbootpractice.websocket.broadcast;
/**
  * 服务器向浏览器发送的此类的消息
  *
  * @author  changzhenzhen
  * @date 2018-11-13
  */
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    /**
     * 属性get方法
     */
    public String getResponseMessage() {
        return responseMessage;
    }
}

