package com.chenjj.spring.boot.configuration;

import org.springframework.beans.factory.annotation.Value;

public class WithoutAnnoConfiguration {
    public WithoutAnnoConfiguration() {
        System.out.println("WithoutAnnoConfiguration对象被创建");
    }

    @Value("${admin.name}")
    private String name;

    @Value("${admin.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
