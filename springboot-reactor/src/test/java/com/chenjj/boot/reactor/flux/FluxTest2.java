package com.chenjj.boot.reactor.flux;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @ClassName FluxTest2
 * @Description
 * @Author chenjunjiang
 * @Date 11:08 2025/5/8
 * @Version 1.0
 **/
public class FluxTest2 {
    public static void main(String[] args) {
        Flux<List<Integer>> flux = Flux.range(1, 10).buffer(3).log();
        /*flux.subscribe(new BaseSubscriber<>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("绑定了关系......");
                // 请求一次数据，一次就是3个元素，和上面设置的bufferSize有关，10个元素请求4次就完了
                request(1);
            }

            @Override
            protected void hookOnNext(List<Integer> value) {
                System.out.println("收到了数据......" + value);
                request(1);
            }
        });*/
        flux.subscribe();
    }
}
