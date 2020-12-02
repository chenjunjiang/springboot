package com.chenjj.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/mock")
    public String mock(String name) {
        return "Hello" + name + "!";
    }

    @GetMapping("/hello")
    public String  hello() {
        return "Hello DevTools xxx";
    }
}
