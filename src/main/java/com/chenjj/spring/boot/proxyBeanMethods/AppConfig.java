package com.chenjj.spring.boot.proxyBeanMethods;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * proxyBeanMethods = true，AppConfig会被代理(CGLib)，被final修饰后就要报错；
 * 如果是proxyBeanMethods = false，AppConfig不会被代理，可以用final修饰
 */
@Configuration(proxyBeanMethods = true)
public /*final*/ class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    /**
     * 如果proxyBeanMethods为false，直接调用方法获取bean，会创建新的MyBean，MyBean
     * 会再次被初始化，Spring 容器中会有两个MyBean。
     * 不建议这样用，idea也会有提示。
     *
     * @param myBean
     * @return
     */
    /*@Bean
    public YourBean yourBean() {
        return new YourBean(myBean());
    }*/

    @Bean
    public YourBean yourBean(MyBean myBean) {
        return new YourBean(myBean);
    }
}
