package com.chenjj.spring.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LogController
 * @Description 日志测试
 * @Author chenjunjiang
 * @Date 19:37 2025/2/8
 * @Version 1.0
 **/
@RestController
@Slf4j
public class LogController {
    // private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log")
    public String log() {
        log.trace("trace来了......");
        log.debug("debug来了......");
        log.info("info来了......");
        log.warn("warn来了......");
        log.error("error来了......");

        return "log 来了......";
    }
}
