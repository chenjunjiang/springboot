package com.chenjj.spring.boot;

import com.chenjj.spring.boot.annotation.Single;
import com.chenjj.spring.boot.annotation.SingleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * https://cloud.tencent.com/developer/article/1692109
 * AnnotatedBeanDefinitionReader的作用：
 * 1、主要是可以动态、显示的注册一个bean；而且具备解析一个类的功能(和扫描解析一个类的功能相同)；
 * AnnotatedBeanDefinitionReader的应用场景：
 * 1、可以显示、动态注册一个程序员提供的bean；
 * 2、在初始化spring容器的过程中完成对配置类的注册和解析功能；
 */
public class AnnotatedBeanDefinitionReaderTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SingleConfig.class);
        context.refresh();
        Single single = context.getBean(Single.class);
        System.out.println(single);
    }
}
