package com.chenjj.spring.boot.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author chenjunjiang
 * @Date 19:53 2025/2/11
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice // 这注解是@ControllerAdvice加上@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerException(Exception e) {
        log.error("全局异常处理：", e.getMessage(), e);
        return "错误了:" + e.getMessage();
    }
}
