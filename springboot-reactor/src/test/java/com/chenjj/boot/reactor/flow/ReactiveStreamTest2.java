package com.chenjj.boot.reactor.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @ClassName ReactiveStreamTest2
 * @Description
 * @Author chenjunjiang
 * @Date 15:15 2025/4/30
 * @Version 1.0
 **/
public class ReactiveStreamTest2 {

    static class MyProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            System.out.println("processor和publisher绑定了关系......" + Thread.currentThread());
            subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            System.out.println("processor接收到数据：" + item + "......" + Thread.currentThread());
            // 处理数据
            String newItem = item + "--哈哈";
            // 将处理后的数据提交到缓冲区，供其他订阅者订阅
            this.submit(newItem);
            // 请求下一次数据
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {
            System.out.println("缓冲区数据取完了......" + Thread.currentThread());
        }
    }

    static class MySubscriber implements Flow.Subscriber<String> {
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            System.out.println("subscriber和processor绑定了关系......" + Thread.currentThread());
            // 订阅者向缓冲区请求第1条数据
            subscription.request(1);
        }

        // 从缓冲区收到数据后执行
        @Override
        public void onNext(String item) {
            System.out.println("subscriber收到了数据：" + item + "......" + Thread.currentThread());
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
    }

    /**
     * publisher发布数据，经过一系列操作（processor）后，subscriber再来订阅；
     * 此时processor既是订阅者，也是发布者；
     *
     * @param args
     */
    public static void main(String[] args) {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        MyProcessor processor = new MyProcessor();
        MySubscriber subscriber = new MySubscriber();

        publisher.subscribe(processor);
        processor.subscribe(subscriber);

        System.out.println("开始向缓冲区提交数据......" + Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            publisher.submit("hello world：" + i);
        }

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 关闭发布者，订阅者会执行onComplete()
        publisher.close();
    }
}
