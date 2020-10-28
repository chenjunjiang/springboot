package com.chenjj.spring.boot.proxyBeanMethods;

import javax.annotation.PostConstruct;

public class MyBean {
    public MyBean() {
        System.out.println("MyBean construct......");
    }

    /**
     *  被@PostConstruct注解的方法,在对象依赖注入后执行
     *  该注解的方法在整个Bean初始化中的执行顺序：
     *  Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
     */
    @PostConstruct
    public void init() {
        System.out.println("MyBean PostConstruct ....");
    }

    public void sayHello() {
        System.out.println("Hi MyBean ,hello world!");
    }
}
