package com.highlig_spring4.ch2.diconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * //TODO 添加类/接口功能描述
 *
 * @author changzhenzhen
 * @date 2018-09-29
 */

//使用@Configuration声明当前类是一个配置类
//使用@ComponentScan，自动扫描包名下所有使用@Service、@Component、@Repository和@Controller的类并注册为Bean

@Configuration
@ComponentScan("com.highlig_spring4.ch2.diconfig")
public class DiConfig {
}
