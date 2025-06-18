package com.chenjj.boot.reactor.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ApiTest
 * @Description
 * @Author chenjunjiang
 * @Date 16:47 2025/5/8
 * @Version 1.0
 **/
public class ApiTest {

    @Test
    public void filter(){
        Flux.just(1,2,3,4,5,6)
                .log()
                .filter(data -> data%2==0)
                .subscribe();
    }

    @Test
    public void flatMap(){
        Flux.just("zhang san", "li si")
                .flatMap(name -> Flux.fromArray(name.split(" ")))
                .log()
                .subscribe();
    }

    @Test
    public void concatMap(){
        Flux.just(1,2,3,4,5,6).concatMap(data -> Flux.just(data*10))
                .log()
                .subscribe();
    }

    /**
     * 无论怎么延迟，都会先执行完前面的1,2,3，再执行后面的a,b,c
     */
    @Test
    public void concat(){
        Flux.concat(Flux.just(1,2,3).delayElements(Duration.ofSeconds(2)),
                        Flux.just("a","b","c").delayElements(Duration.ofSeconds(1)))
                .log()
                .subscribe();
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 不会按照顺序执行，谁的时间先到就先执行谁
     */
    @Test
    public void merge(){
        Flux.merge(Flux.just(1,2,3).delayElements(Duration.ofSeconds(2)),
                        Flux.just("a","b","c").delayElements(Duration.ofSeconds(1)))
                .log()
                .subscribe();

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 和concat效果一样
     */
    @Test
    public void mergeSequential(){
        Flux.mergeSequential(Flux.just(1,2,3).delayElements(Duration.ofSeconds(2)),
                        Flux.just("a","b","c").delayElements(Duration.ofSeconds(1)))
                .log()
                .subscribe();

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transform(){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux<String> stringFlux = Flux.just("a", "b", "c")
                .transform(flux -> {
                    System.out.println("开始执行......"+atomicInteger.get());
                    if (atomicInteger.incrementAndGet() == 1) {
                        return flux.map(String::toUpperCase);
                    } else {
                        return flux;
                    }
                }).log();
        /*Flux<String> stringFlux = Flux.just("a", "b", "c")
                .transformDeferred(flux -> {
                System.out.println("开始执行......"+atomicInteger.get());
                    if (atomicInteger.incrementAndGet() == 1) {
                        return flux.map(String::toUpperCase);
                    } else {
                        return flux;
                    }
                }).log();*/
        // 对于transform，多次订阅只会执行一次里面的代码
        // 对于transformDeferred，多次订阅会多次执行里面的代码
        stringFlux.subscribe() ;
        stringFlux.subscribe() ;
    }

    /**
     * 1和d配对，然后连接起来；
     * 2和e配对，然后连接起来；
     * 3和f配对，然后连接起来；
     * g没有配对的，会被忽略。
     */
    @Test
    public void zip(){
        Flux.zip(Flux.just(1, 2, 3), Flux.just("d", "e", "f", "g"), (a, b) -> a + b)
                .log()
                .subscribe();
    }

    @Test
    public void error1(){
        Flux.just(1,2,3,0,5).map(data -> 10/data)
                .onErrorComplete()// 出现异常后正常结束，消费者不会感知到异常
                .log()
                .subscribe(v-> System.out.println("正常："+v),throwable -> System.out.println("异常："+throwable));
    }

    @Test
    public void error2(){
        Flux.just(1,2,3,0,5).map(data -> 10/data)
                .onErrorMap(throwable -> new RuntimeException("出现异常："+throwable))
                .log()
                .subscribe(v-> System.out.println("正常："+v),throwable -> System.out.println("异常："+throwable));
    }

    @Test
    public void error3(){
        Flux.just(1,2,3,0,5).map(data -> 10/data)
                .onErrorResume(throwable -> { // 出现异常时，返回一个兜底的值
                    return Flux.just(100);
                })
                .log()
                .subscribe(v-> System.out.println("正常："+v),throwable -> System.out.println("异常："+throwable));
    }

    @Test
    public void error4(){
        Flux.just(1,2,3,0,5).map(data -> 10/data)
                .onErrorContinue((throwable, o) -> {
                    System.out.println("出现异常："+throwable+"，但是流不会中断，会继续执行，并且会正常结束......");
                })
                .log()
                .subscribe(v-> System.out.println("正常："+v),throwable -> System.out.println("异常："+throwable));
    }
}
