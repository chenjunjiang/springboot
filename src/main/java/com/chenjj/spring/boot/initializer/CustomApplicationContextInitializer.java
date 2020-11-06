package com.chenjj.spring.boot.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 通过3种方法调用该类
 * 第一种方法就是参考Spring Boot源代码中的操作，将该实现类配置于META-INF/spring.factories文件中
 * 第二种方法是通过application.properties或application.yml文件进行配置，格式如下:
 * context.initializer.classes=com.chenjj.spring.boot.initializer.CustomApplicationContextInitializer
 * 第三种方法是通过SpringApplication提供的addInitializers方法进行追加配置
 */
public class CustomApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 打印容器里面初始化了多少个Bean
        System.out.println(applicationContext.getBeanDefinitionCount());
    }
}
