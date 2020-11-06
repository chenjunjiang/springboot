package com.chenjj.spring.boot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("监听器获得容器中初始化Bean数量:" + event.getApplicationContext().getBeanDefinitionCount());
    }
}
