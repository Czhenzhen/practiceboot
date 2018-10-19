package com.highlig_spring4.ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import sun.nio.ch.IOUtil;

import java.io.IOException;

/**
 * Spring Aware演示Bean
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
@Service
//实现BeanNameAware、ResourceLoaderAware接口，获得Bean名称和资源加载的服务
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;

    private ResourceLoader loader;

    //实现BeanNameAware需要重写setBeanName方法
    @Override
    public void setBeanName(String s) {
        this.beanName = s;

    }

    //实现ResourceLoaderAware接口，需要重写setResourceLoader方法
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() {
        System.out.println("Bean的名称：" + beanName);
        Resource resource = loader.getResource("classpath:com/test.txt");
        try {
            System.out.println("Resource加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
