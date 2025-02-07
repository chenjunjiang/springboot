package com.chenjj.spring.boot.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * 当定义好实现类之后，像注册其他监听器一样，程序在spring.factories中进行注册配置。如果项目中没有
 * spring.factories文件，也可在resources目录下先创建META-INF目录，然后在该目录下创建文件spring.factories。
 */
public class MyApplicationRunListener implements SpringApplicationRunListener {
    public MyApplicationRunListener(SpringApplication application, String[] args) {
        System.out.println("MyApplicationRunListener constructor......");
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("MyApplicationRunListener starting invoke......");
        SpringApplicationRunListener.super.starting(bootstrapContext);
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("MyApplicationRunListener environmentPrepared invoke......");
        SpringApplicationRunListener.super.environmentPrepared(bootstrapContext, environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MyApplicationRunListener contextPrepared invoke......");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MyApplicationRunListener contextLoaded invoke......");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("MyApplicationRunListener started invoke......");
        SpringApplicationRunListener.super.started(context, timeTaken);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MyApplicationRunListener failed invoke......");
    }
}
