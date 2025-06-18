package com.chenjj.boot.reactor.flux;

import reactor.core.publisher.Flux;

/**
 * @ClassName FluxTest5
 * @Description
 * @Author chenjunjiang
 * @Date 15:54 2025/5/8
 * @Version 1.0
 **/
public class FluxTest5 {
    public static void main(String[] args) {
        // 自定义流数据的处理规则，然后生成新的流
        Flux.range(1, 10).handle((data, sink) -> {
            System.out.println("handle处理数据：" + data);
            sink.next("哈哈：" + data);
        }).log().subscribe();
    }
}
