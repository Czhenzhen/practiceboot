package com.highlig_spring4.ch2.scope;

import org.springframework.stereotype.Service;

/**
 * 编写singleton
 * Singleton：一个Spring容器只有一个Bean的实例，此为Spring的默认配置，全容器共享一个实例
 *
 * @author changzhenzhen
 * @date 2018-10-08
 */
@Service
//默认为Singleton，相当于@Scope("singleton")
public class DemoSingletonService {
}
