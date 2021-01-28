package com.chenjj.spring.boot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，
 * 那么在IOC容器中是获取不到properties 配置文件转化的bean。
 * 如果不想使用@Component,可以在Application或者其它Config上加
 * @EnableConfigurationProperties(value = LoginUserConfig.class )
 */
@Component
@ConfigurationProperties(prefix = "user")
public class LoginUserConfig {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

