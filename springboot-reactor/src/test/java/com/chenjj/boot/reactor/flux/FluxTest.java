package com.chenjj.boot.reactor.flux;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

/**
 * @ClassName FluxTest
 * @Description
 * @Author chenjunjiang
 * @Date 18:11 2025/5/7
 * @Version 1.0
 **/
public class FluxTest {
    public static void main(String[] args) {
        Flux<String> flux = Flux.range(1, 10).map(i -> {
            if (i == 9){
                System.out.println(10/0);
            }
            return "哈哈：" + i;
        }).onErrorComplete();// 出现异常后会忽略异常并终止处理，然后将信号设置为完成，所以下面的hookOnError不会执行
        // 而hookOnComplete会执行
        // flux.subscribe(System.out::println);

        // flux.subscribe(System.out::println);
        /*flux.subscribe(
                System.out::println,
                error -> System.out.println("出错了：" + error.getMessage()),
                () -> System.out.println("完成"));*/ // 处理流数据过程中出错就不算完成

        flux.subscribe(new BaseSubscriber<String>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("绑定了关系......"+subscription);
                request(1);
            }

            @Override
            protected void hookOnNext(String value) {
                System.out.println("接受到数据进行处理......"+value);
                if (value.equals("哈哈：6")){
                    cancel();
                }
                request(1);
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("所有数据处理完成，没有发生异常......");
            }

            @Override
            protected void hookOnError(Throwable throwable) {
                System.out.println("数据处理过程中发生异常......" + throwable.getMessage());
            }

            @Override
            protected void hookOnCancel() {
                System.out.println("数据处理取消......");
            }

            @Override
            protected void hookFinally(SignalType type) {
                System.out.println("无论如何最后都会执行......" + type);
            }
        });
    }
}
