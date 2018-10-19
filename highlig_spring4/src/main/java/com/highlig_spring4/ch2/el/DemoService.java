package com.highlig_spring4.ch2.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
  * 需被注入的Bean
  *
  * @author  changzhenzhen
  * @date 2018-10-08
  */
@Service
public class DemoService {

    //注入普通的字符串
    @Value("其他类的属性")
    private String another;

    /**
     * 属性get方法
     */
    public String getAnother() {
        return another;
    }

    /**
     * 属性set方法
     */
    public void setAnother(String another) {
        this.another = another;
    }
}
