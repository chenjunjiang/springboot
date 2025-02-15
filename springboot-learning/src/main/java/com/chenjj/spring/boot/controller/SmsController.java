package com.chenjj.spring.boot.controller;

import com.chenjj.springboot.sms.service.SmsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ClassName SmsController
 * @Description 调用自定义starter发送短信
 * @Author chenjunjiang
 * @Date 2025/2/15 18:09
 */
@RestController
public class SmsController {
    @Resource
    private SmsService smsService;

    @GetMapping("/sms")
    public String sendSms() {
        smsService.sendSms();
        return "发送短信成功";
    }
}
