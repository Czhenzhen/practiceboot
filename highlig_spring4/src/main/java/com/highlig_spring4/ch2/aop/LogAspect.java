package com.highlig_spring4.ch2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 编写切面
 *
 * @author changzhenzhen
 * @date 2018-09-30
 */
//通过@Aspect注解声明一个切面
@Aspect
//通过@Component让此切面成为Spring容器管理的Bean
@Component
public class LogAspect {

    //通过@PointCut注解声明切点
    @Pointcut("@annotation(com.highlig_spring4.ch2.aop.CustomAnnotation)")
    public void annotationPointCut() {

    }

    //通过@After注解声明一个建言，并使用@PonitCut定义的切点
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CustomAnnotation action = method.getAnnotation(CustomAnnotation.class);
        //通过反射可以获取注解上的属性，然后做日志记录相关的操作，下面的相同
        System.out.println("注解式拦截:"+action.describe());

    }

    //通过@Before注解声明一个建言，此建言使用拦截规则作为参数
    @Before("execution(* com.highlig_spring4.ch2.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截：" + method.getName());
    }

}
