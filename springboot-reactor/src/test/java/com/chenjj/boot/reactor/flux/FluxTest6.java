package com.chenjj.boot.reactor.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;

/**
 * @ClassName FluxTest6
 * @Description 自定义线程池进行调度
 * @Author chenjunjiang
 * @Date 16:13 2025/5/8
 * @Version 1.0
 **/
public class FluxTest6 {
    public static void main(String[] args) throws InterruptedException, IOException {
       /* final Mono<String> mono = Mono.just("hello ").log();

        // 订阅、请求数据、获取结果等操作都是用的自定义线程，而不是main线程
        Thread t = new Thread(() -> mono.map(msg -> msg + "thread ")
                .subscribe(v -> System.out.println(v + Thread.currentThread().getName())));
        t.start();
        t.join();*/

        // 自定义线程池
        Scheduler publishScheduler = Schedulers.newParallel("my-publish-pool", 2);
        Scheduler subscribeScheduler = Schedulers.newParallel("my-subscribe-pool", 2);
        Flux.range(1, 10).map(i -> 10+i).log().publishOn(publishScheduler)
                .map(i -> "value " + i).log().subscribeOn(subscribeScheduler).subscribe();

        System.in.read();
    }
}
