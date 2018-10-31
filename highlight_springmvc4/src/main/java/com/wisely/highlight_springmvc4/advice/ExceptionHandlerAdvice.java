package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;



/**
  * 定制ControllerAdvice
  *
  * @author  changzhenzhen
  * @date 2018-10-30
  */

//@ControllerAdvice声明一个控制器建言，
// 组合了@Component注解，自动注解为Spring的Bean
@ControllerAdvice
public class ExceptionHandlerAdvice {


    //@ExceptionHandler在此处定义全局处理，
    // 通过@ExceptionHandler的value属性可过滤拦截条件，
    // 再此处可以看出拦截所有的Exception
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");//error页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    /**
     * 使用@ModelAttribute将键值对添加到全局，
     * 所有的@Requestmappingd的方法可获得此键值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    /**
     * 通过@InitBinder注解定制WebDataBinder
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //此处忽略request参数的id
        webDataBinder.setDisallowedFields("id");
    }
}
