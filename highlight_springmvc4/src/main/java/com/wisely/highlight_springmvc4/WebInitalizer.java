package com.wisely.highlight_springmvc4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Web配置
 *
 * @author changzhenzhen
 * @date 2018-10-24
 */
//webApplicationInitializer是spring提供用来配置Servlet3.0+配置的接口，
// 从而实现了替代web.xml的位置。
// 实现此接口将会自动被SpringServletContainerInitializer（用来启动Servlet3.0容器）获取到
public class WebInitalizer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        //新建WebApplicationContext，注册配置类，并将其和当前的servletContext关联
        ctx.setServletContext(servletContext);

        //注册Spring MVC的dispatcherServlet
        Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
