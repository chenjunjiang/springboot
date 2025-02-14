package com.chenjj.spring.boot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event + " 事件到达了=======");
    }
    /*@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("监听器获得容器中初始化Bean数量:" + event.getApplicationContext().getBeanDefinitionCount());
    }*/
}
