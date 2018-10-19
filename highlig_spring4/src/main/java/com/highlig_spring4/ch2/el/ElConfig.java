package com.highlig_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;


/**
  * 配置类
  *
  * @author  changzhenzhen
  * @date 2018-10-08
  */
@Configuration
@ComponentScan("com.highlig_spring4.ch2.el")
@PropertySource("classpath:com/highlig_spring4/ch2/el/test.properties")
public class ElConfig {

    //注入普通的字符串
    @Value("I Love You!")
    private String normal;

    //注入操作系统的属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    //注入表达式结果
    @Value("#{ T(java.lang.Math).random()*100.0}")
    private double roundNumber;

    //注入其他bean的属性
    @Value("#{demoService.another}")
    private String fromAnther;

    //注入文件资源
    @Value("classpath:com/highlig_spring4/ch2/el/test.txt")
    private Resource testFile;

    //注入网页资源
    @Value("http://www.baidu.com")
    private Resource testUrl;

    //注入配置文件
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    //注入配置配件需要使用@PropertySource指定文件地址，
    // 若使用@Value注入，则要配置一个PropertySourcePlaceHolderConfigure的Bean
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }


    public void outputResource()  {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(roundNumber);
            System.out.println(fromAnther);
            System.out.println(IOUtils.toString(testFile.getInputStream()));

            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            //注入properties可以从environment中获得
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
