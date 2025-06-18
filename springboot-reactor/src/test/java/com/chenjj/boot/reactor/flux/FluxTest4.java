package com.chenjj.boot.reactor.flux;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName FluxTest4
 * @Description
 * @Author chenjunjiang
 * @Date 14:19 2025/5/8
 * @Version 1.0
 **/
public class FluxTest4 {
    public static void main(String[] args) {
        // 自定义流数据
        /*Flux<String> flux = Flux.generate(() -> 0, (state, sink) -> {
            sink.next("3*" + state + "=" + 3 * state);
            if (state == 10) {
                sink.complete();
            }
            return state + 1;
        }, state -> System.out.println("state:" + state));// 打印state最后的值

        flux.log().subscribe(v -> {
            // Thread[#1,main,5,main]收到数据：
            System.out.println(Thread.currentThread() + "收到数据：" + v);
        });*/


        /**
         * create方法允许在异步或多线程环境中发射数据
         */
        MyEventProcessor myEventProcessor = new MyEventProcessor();
        Flux<String> bridge = Flux.create(sink -> {
            myEventProcessor.register(
                    new MyEventListener<String>() {
                        public void onDataChunk(String event) {
                            sink.next(event);
                        }

                        public void processComplete() {
                            sink.complete();
                        }
                    });
        });

        // 触发事件
        myEventProcessor.processEvent();

        bridge.log().subscribe();
    }

    static class MyEventProcessor {
        private final ExecutorService executorService = Executors.newSingleThreadExecutor();
        private MyEventListener listener;

        public void register(MyEventListener listener) {
            // 注册监听器
            this.listener = listener;
        }

        // 模拟事件触发
        public void processEvent() {
            executorService.execute(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                        if (listener != null) {
                            listener.onDataChunk("Event-" + i);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (listener != null) {
                    listener.processComplete();
                }
            });
        }
    }
}
