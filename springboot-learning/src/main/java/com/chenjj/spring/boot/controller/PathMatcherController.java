package com.chenjj.spring.boot.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PathMatcherController
 * @Description
 * @Author chenjunjiang
 * @Date 19:47 2025/2/10
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PathMatcherController {
    /**
     * 如果不把策略改成ant_path_matcher，启动就会报错：
     * Caused by: org.springframework.web.util.pattern.PatternParseException:
     * No more pattern data allowed after {*...} or ** pattern element
     * @param request
     * @param path
     * @return
     */
    @GetMapping("/a*/**/b?/{p1:[a-f]+}")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path) {
        log.info("路径变量p1： {}", path);
        String uri = request.getRequestURI();
        return uri;
    }
}
