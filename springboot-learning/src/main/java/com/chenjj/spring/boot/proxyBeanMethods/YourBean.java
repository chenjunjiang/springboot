package com.chenjj.spring.boot.proxyBeanMethods;


import jakarta.annotation.PostConstruct;

public class YourBean {
    public MyBean myBean;

    public YourBean(MyBean myBean) {
        System.out.println("YourBean construct...");
        this.myBean = myBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("YourBean PostConstruct...");
    }

    public void sayHello() {
        System.out.println("Hi YourBean ,hello world!");
    }
}
