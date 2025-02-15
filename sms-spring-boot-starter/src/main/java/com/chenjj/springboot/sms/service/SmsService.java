package com.chenjj.springboot.sms.service;

import com.chenjj.springboot.sms.properties.SmsProperties;

/**
 * @version 1.0
 * @ClassName SmsService
 * @Description
 * @Author chenjunjiang
 * @Date 2025/2/15 17:37
 */
public class SmsService {
    private SmsProperties smsProperties;

    public SmsService() {
    }

    public SmsService(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }

    public void sendSms() {
        System.out.println("发送短信给：" + smsProperties.getPhone() + "，内容是：" + smsProperties.getContent());
    }
}
