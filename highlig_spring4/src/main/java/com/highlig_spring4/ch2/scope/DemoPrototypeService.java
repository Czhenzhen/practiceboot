package com.highlig_spring4.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 编写Prototype的Bean
 * Prototype：每次调用创建一个Bean的实例
 * Request:Web项目中，给每一个http request新建一个Bean的实例
 * Session:Web项目中，给每一个http session新建一个Bean的实例
 * GlobalSession：这个只在portal应用中有用，给每一个global http session新建一个Bean的实例
 *
 * @author changzhenzhen
 * @date 2018-10-08
 */
@Service
@Scope("prototype")
//声明Scope为prototype
public class DemoPrototypeService {
}
