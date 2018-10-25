package com.wisely.highlight_springmvc4.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
  * 注解演示控制器
  *
  * @author  changzhenzhen
  * @date 2018-10-25
  */

//@Controller声明此类是一个控制器
@Controller
//@RequestMapping("anno")映射此类的访问路径为/anno
@RequestMapping("/anno")
public class DemoAnnoController {

    //此方法未标注路径，使用类访问路径"/anno"，
    // produces可定制返回的response的媒体类型和字符集，
    // 或需返回值是json对象，则设置produces="application/json;charset=UTF-8".
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access ";
    }

    //接受路径参数，并在方法参数前结合@PathVariable使用，访问路径为/anno/pathvar/xx
    @RequestMapping(value ="/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPath(@PathVariable String str,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can assess ,str:"+str;
    }

    //演示常规的request参数获取，访问路径为/anno/requestParam?id=1
    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        return "url:"+request.getRequestURL()+"can assess,id:"+id;
    }

    //演示解释参数到对象，访问路径为/anno/obj?id=1&name=xx
    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can assess,obj id:"+obj.getId()+"obj name:"+obj.getName();
    }

    //演示映射不同的路径到相同的方法上，访问路径为/anno/name1或/anno/name2
    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can assess ";
    }
}
