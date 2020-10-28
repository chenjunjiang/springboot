package com.chenjj.spring.boot;

import com.chenjj.spring.boot.proxyBeanMethods.AppConfig;
import com.chenjj.spring.boot.proxyBeanMethods.MyBean;
import com.chenjj.spring.boot.proxyBeanMethods.YourBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {
    @Test
    public void refresh() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        MyBean myBean = context.getBean(MyBean.class);
        myBean.sayHello();
        YourBean yourBean = context.getBean(YourBean.class);
        yourBean.sayHello();
    }
}
