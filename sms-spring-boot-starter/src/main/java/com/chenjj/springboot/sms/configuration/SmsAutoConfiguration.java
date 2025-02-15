package com.chenjj.springboot.sms.configuration;

import com.chenjj.springboot.sms.properties.SmsProperties;
import com.chenjj.springboot.sms.service.SmsService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @ClassName SmsAutoConfiguration
 * @Description
 * @Author chenjunjiang
 * @Date 2025/2/15 17:16
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfiguration {
    @Bean
    public SmsService smsService(SmsProperties smsProperties) {
        return new SmsService(smsProperties);
    }
}
