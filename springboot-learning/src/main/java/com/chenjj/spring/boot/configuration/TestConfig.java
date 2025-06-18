package com.chenjj.spring.boot.configuration;

import com.chenjj.spring.boot.dao.TestDao;
import com.chenjj.spring.boot.properties.DatabaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    /*@Bean
    public TestDao testDao(){
        *//**
         * 这里不能直接返回null，否则会报：
         *The following candidates were found but could not be injected:
         * 	- User-defined bean method 'testDao' in 'TestConfig' ignored as the bean value is null
         *//*
        //return null;
        return new TestDao();
    }*/
    // 在方法上使用@ConfigurationProperties注解，也会把配置的属性绑定到DatabaseProperties上
    @Bean
    @ConfigurationProperties(prefix = "database")
    public DatabaseProperties databaseProperties(){
        return new DatabaseProperties();
    }
}