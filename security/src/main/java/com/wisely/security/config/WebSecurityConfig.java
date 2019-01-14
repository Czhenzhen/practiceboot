package com.wisely.security.config;

import com.wisely.security.service.CustomerUserService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
  * Spring Security 配置
  *
  * @author  changzhenzhen
  * @date 2019-01-09
  */
//@Configuration
//@EnableWebSecurity
//扩展Spring Security需继承WebSecurityConfigurerAdapter
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //注册CustomerUserService的bean
    @Bean
    UserDetailsService customerUserService(){
        return new CustomerUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //添加自定义的user detail service的认证
        auth.userDetailsService(customerUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //所有请求需要认证即登录后才能访问
                .anyRequest().authenticated()
                .antMatchers("/","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login11")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error")
                //定制登录行为，登录页面可任意访问
                .permitAll()
                .and()
                .logout().permitAll();//定制注销行为，注销请求可随意访问

        System.out.println("33333333333333333333333");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/*");
    }
}
