package com.wisely.ch5_2_3.practice;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;

/**
  * 配置类，也可在application.properties中直接配置
  *类型安全
  * @author  changzhenzhen
  * @date 2018-11-05
  */
//在application.properties配置的时候前缀是spring.http.encoding
@ConfigurationProperties(prefix = "spring.http.encoding")
public class HttpEncodingProperties {

    private static final Charset DEFAUT_CHARSET = Charset.forName("utf-8");

    //设置默认编码格式是utf-8，若修改可使用spring.http.encoding.charset=编码
    private Charset charset = DEFAUT_CHARSET;

    //设置forceEncoding，默认为true，若修改可使用spring.http.encoding.force=false
    private boolean force = true;

    /**
     * 属性get方法
     */
    public static Charset getDefautCharset() {
        return DEFAUT_CHARSET;
    }

    /**
     * 属性get方法
     */
    public Charset getCharset() {
        return charset;
    }

    /**
     * 属性set方法
     */
    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    /**
     * 属性get方法
     */
    public boolean isForce() {
        return force;
    }

    /**
     * 属性set方法
     */
    public void setForce(boolean force) {
        this.force = force;
    }
}
