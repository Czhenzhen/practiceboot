package com.wisely.highlight_springmvc4.web.che4_6;

import com.wisely.highlight_springmvc4.service.DemoService;
import com.wisely.highlight_springmvc4.MyMvcConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
  *
 * 测试用例
  *
  * @author  changzhenzhen
  * @date 2018-11-02
  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
//@WebAppConfiguration注解在类上，
// 用来声明加载的ApplicationContext是一个WebApplicationContext。
//他的属性指的是Web资源的位置，默认为src/main/webapp,本例修改为/src/main/resource
@WebAppConfiguration("/sec/main/resource")
public class TestControllerIntegrationTests {

    //MockMvc模拟MVC对象，
    // 通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化
    private MockMvc mockMvc;

    //测试用例中注入Spring的Bean
    @Autowired
    private DemoService demoService;

    //注入WebApplicationContext
    @Autowired
    WebApplicationContext wac;

    //可以注入模拟的http Session
    @Autowired
    MockHttpSession session;

    //注入模拟的Http request
    @Autowired
    MockHttpServletRequest request;

    //测试开始之前进行初始化工作
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNormalController()throws Exception{
        mockMvc.perform(get("/normal"))//模拟向/normal发送get请求
                .andExpect(status().isOk())//预期控制返回状态为200
                .andExpect(view().name("page"))//预期view的名称为page
                .andExpect(forwardedUrl("/WEB-INF/classes/view/page.jsp"))//预期页面转向的真正路径为/WEB-INF/classess/views/page.jsp
                .andExpect(model().attribute("msg",demoService.saySomething()));//预期model里的返回值是demoService.saySomenthing()返回值hello
    }

    @Test
    public void testRestController()throws Exception{
        mockMvc.perform(get("/testRest"))//模拟向testRest发送get请求
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;Charset=UTF-8"))//预期返回值的媒体类型为text/plain;charset=utf-8
                .andExpect(content().string(demoService.saySomething()));//预期model里的返回值是demoService.saySomenthing()返回值hello
    }

}
