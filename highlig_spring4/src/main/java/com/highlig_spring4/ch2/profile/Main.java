package com.highlig_spring4.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类
 *
 * @author changzhenzhen
 * @date 2018-10-17
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configContext = new AnnotationConfigApplicationContext();
        //先将活动的Profile设置为prod
        configContext.getEnvironment().setActiveProfiles("dev");
        //后置注册Bean配置类，不然会报Bean未定义的错误
        configContext.register(ProfileConfig.class);
        //刷新容器
        configContext.refresh();
        DemoBean demoBean = configContext.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        configContext.close();
    }
}
