package com.highlig_spring4.ch2.aop;

import org.springframework.stereotype.Service;

/**
 * 使用注解被拦截的类
 *
 * @author changzhenzhen
 * @date 2018-09-30
 */
@Service
public class DemoAnnotationService {

    @CustomAnnotation(describe = "注解拦截的add操作")
    public void add() {

    }
}
