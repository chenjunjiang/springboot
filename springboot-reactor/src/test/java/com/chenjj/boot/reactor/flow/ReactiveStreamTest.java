package com.chenjj.boot.reactor.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @ClassName ReactiveStreamTest
 * @Description java9提供了流式编程，4个关键组件：
 * 1、发布者 Publisher
 * 2、订阅者 Subscriber
 * 3、发布订阅关系 Subscription
 * 4、处理器 Processor
 *
 * 背压(Backpressure)机制
 * Flow API的一个关键特性是内置的背压支持，这使得Subscriber可以控制它从Publisher接收数据的速度，防止被快速产生的数据淹没。
 * 通过Subscription.request(long n)方法，Subscriber可以明确请求特定数量的数据项。
 * @Author chenjunjiang
 * @Date 14:23 2025/4/30
 * @Version 1.0
 **/
public class ReactiveStreamTest {
    public static void main(String[] args) {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        Flow.Subscriber subscriber1 = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("subscriber1和publisher绑定了关系......" + Thread.currentThread());
                // 订阅者向缓冲区请求第1条数据
                subscription.request(1);
            }

            // 从缓冲区收到数据后执行
            @Override
            public void onNext(Object item) {
                System.out.println("subscriber1收到了数据：" + item + "......" + Thread.currentThread());
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // 订阅者收到数据后向缓冲区请求下1条数据
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("缓冲区数据取完了......" + Thread.currentThread());
            }
        };

        Flow.Subscriber subscriber2 = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("subscriber2和publisher绑定了关系......" + Thread.currentThread());
                // 订阅者向缓冲区请求第1条数据
                subscription.request(1);
            }

            // 从缓冲区收到数据后执行
            @Override
            public void onNext(Object item) {
                System.out.println("subscriber2收到了数据：" + item + "......" + Thread.currentThread());
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // 订阅者收到数据后向缓冲区请求下1条数据
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("缓冲区数据取完了......" + Thread.currentThread());
            }
        };

        // 订阅者和发布者绑定关系，要在发布者向缓冲区提交数据之前执行绑定关系
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        System.out.println("开始向缓冲区提交数据......" + Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            publisher.submit("hello world：" + i);
        }

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 关闭发布者，订阅者1和订阅者2都会执行onComplete()
        publisher.close();
    }
}
