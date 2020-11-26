package com.chenjj.spring.boot.controller;

import com.chenjj.spring.boot.configuration.LoginUserConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Value("${user.username}")
    private String username;
    @Value("${user.password}")
    private String password;

    @Resource
    private LoginUserConfig loginUserConfig;

    // 当projectName参数不存在或未在application中配置时，会使用指定的默认值。
    @Value("${projectName:unknown}")
    private String projectName;

    @RequestMapping("/")
    public String getConfigParams() {
        // 启动命令传递参数
        System.out.println("Command config projectName:" + projectName);
        // 通过application配置文件配置的参数
        System.out.println("Application config Username:" + username);
        System.out.println("Application config Password:" + password);

        // 通过@ConfigurationProperties注解配置的参数
        System.out.println("ConfigurationProperties config Username:" + username);
        System.out.println("ConfigurationProperties config Password:" + password);

        return "00";
    }
}
