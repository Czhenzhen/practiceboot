package com.wisely.springbootpractice.websocket.pointtopoint;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * spring security 的配置
 *
 * @author changzhenzhen
 * @date 2018-11-13
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //Spring Security 对"/"和"/login"路径不拦截
                .antMatchers("/", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //设置Spring Security的登录页面访问的路径为/login
                .loginPage("/login")
                //登录成功后返回/chat路径
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /**
     * 在内存中分别配置另个用户czz和mfl，密码和用户名一致，角色是USER
     *
     * @param auth
     * @return
     * @author changzhenzhen
     * date 2018-11-14
     **/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                //Spring security 5.0中新增了多种加密方式，也改变了密码的格式
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("czz")
                .password(new BCryptPasswordEncoder().encode("czz")).roles("USER")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("mfl")
                .password(new BCryptPasswordEncoder().encode("mfl")).roles("USER");
    }

    /**
     * /resource/static/目录下的静态资源，Spring Security不拦截
     *
     * @param web
     * @return
     * @author changzhenzhen
     * date 2018-11-14
     **/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resource/static/**");
    }
}
