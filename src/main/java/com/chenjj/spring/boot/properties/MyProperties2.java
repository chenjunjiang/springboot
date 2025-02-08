package com.chenjj.spring.boot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyProperties2
 * @Description
 * @Author chenjunjiang
 * @Date 19:25 2025/2/8
 * @Version 1.0
 **/
@Component
@PropertySource("classpath:my2.properties")
@ConfigurationProperties(prefix = "my2")
@Data
public class MyProperties2 {
    private String name;
    private int age;
    private String email;
}
