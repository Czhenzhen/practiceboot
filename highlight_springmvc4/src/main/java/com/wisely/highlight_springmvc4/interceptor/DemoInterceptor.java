package com.wisely.highlight_springmvc4.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 示例拦截器
 *
 * @author changzhenzhen
 * @date 2018-10-25
 */

//继承HandlerInterceptorAdapter类来实现自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter {

    //重写preHandle方法，在请求发生前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    //重写postHandle方法，在请求完成后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求的接口为："+request.getRequestURL()+"请求类型："+request.getMethod());
        Long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        Long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理的时间为："+(endTime-startTime)+"ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }



}
