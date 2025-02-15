package com.chenjj.springboot.sms.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

/**
 * @version 1.0
 * @ClassName SmsProperties
 * @Description
 * @Author chenjunjiang
 * @Date 2025/2/15 17:16
 */
@Data
@ConfigurationProperties(prefix = "sms")
public class SmsProperties {
    private String phone;
    private String content;
}
