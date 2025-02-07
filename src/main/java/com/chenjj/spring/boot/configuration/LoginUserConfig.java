package com.chenjj.spring.boot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，
 * 那么在IOC容器中是获取不到配置类对应的bean，不能完成属性绑定;
 * 如果不想使用@Component,可以在Application或者其它Config上加
 *
 * @EnableConfigurationProperties(value = LoginUserConfig.class )，
 * @EnableConfigurationProperties注解会把指定的类注册到IOC容器中； 如果在我们自己的代码中操作属性绑定，使用@Component + @ConfigurationProperties即可；
 * 如果要操作三方包中的属性绑定，需要使用@EnableConfigurationProperties把三方包中的配置类注册到IOC容器中，
 * 或者使用@Import，把三方包中的配置类注册到IOC容器中。
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

