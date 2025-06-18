package com.chenjj.spring.boot.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @ClassName HelloController
 * @Description
 * @Author chenjunjiang
 * @Date 18:10 2025/5/9
 * @Version 1.0
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello World!");
    }

    @GetMapping("/numbers")
    public Flux<Integer> getNumbers() {
        return Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    /**
     * 服务端推送，模拟大模型中的流式输出
     * 默认输出会加上“data:”前缀，比如：
     * data:1
     * data:4
     * @return
     */
    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> sse() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> i * i);
    }

    /**
     * 浏览器会显示：
     * id:1
     * event:message
     * data:haha: 1
     *
     * id:2
     * event:message
     * data:haha: 2
     *
     * id:3
     * event:message
     * data:haha: 3
     * @return
     */
    @GetMapping(value = "/sse1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> sse1() {
        return Flux.range(1, 10)
                .map(i -> {
                    return ServerSentEvent.<String>builder()
                            .id(String.valueOf(i))
                            .event("message")
                            .data("haha: " + i)
                            .build();
                })
                .delayElements(Duration.ofSeconds(1));
    }
}
