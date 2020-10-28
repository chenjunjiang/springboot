package com.chenjj.spring.boot.configuration;

import com.chenjj.spring.boot.service.MemberRegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这里如果不想使用@Configuration，但是还想MemberRegisterService被创建成Bean，可以
 * 在classpath的META-INF/spring.factories文件中配置：
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
 *   com.chenjj.spring.boot.configuration.MemberAutoConfiguration
 */
// @Configuration
public class MemberAutoConfiguration {
    @Bean
    public MemberRegisterService registerService() {
        return new MemberRegisterService();
    }

}
