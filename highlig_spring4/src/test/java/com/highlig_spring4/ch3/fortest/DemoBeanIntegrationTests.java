package com.highlig_spring4.ch3.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类
 *
 * @author changzhenzhen
 * @date 2018-10-23
 */

//SpringJUnit4ClassRunner在Junit环境下提供Spring TestContext Framework的功能
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration用来加载配置ApplicationContext，其中classes属性用来加载配置类
@ContextConfiguration(classes = {TestConfig.class})
//用来声明活动的profile
@ActiveProfiles("dev")
public class DemoBeanIntegrationTests {

    //注入Bean
    @Autowired
    private TestBean testBean;

    //测试代码，通过JUnit的Assert来校验结果是否和预期一致
    @Test
    public void prodBeanShoudInject(){
        String expected = "dev";
        String actual = testBean.getContent();
        Assert.assertEquals(expected,actual);
    }
}
