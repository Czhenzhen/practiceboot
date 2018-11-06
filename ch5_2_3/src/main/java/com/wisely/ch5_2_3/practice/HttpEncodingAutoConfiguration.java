package com.wisely.ch5_2_3.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
  * 配置bean
  *
  * @author  changzhenzhen
  * @date 2018-11-06
  */

@Configuration
//开启属性注入，通过@EnableConfigurationProperties声明，使用@Autowired注入
@EnableConfigurationProperties(HttpEncodingProperties.class)
//当characterEncodingFilter在类路径的条件下
@ConditionalOnClass(CharacterEncodingFilter.class)
//当设置spring.http.encoding=enabled的情况下，如果没有设置则默认为true，即条件符合
@ConditionalOnProperty(prefix = "spring.http.encoding",value = "enabled",matchIfMissing = true)
public class HttpEncodingAutoConfiguration {

    @Autowired
    private HttpEncodingProperties httpEncodingProperties;

    //像使用java配置的方式配置CharacterEncodingFilter这个Bean
    @Bean
    //当容器中没有这个Bean的时候新建Bean
    @ConditionalOnMissingBean(CharacterEncodingFilter.class)
    public CharacterEncodingFilter characterEncodingFilter(){
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding(this.httpEncodingProperties.getCharset().name());
        filter.setForceEncoding(this.httpEncodingProperties.isForce());
        return filter;
    }
}
