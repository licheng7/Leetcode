package org.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Stream;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/5/20
 * Time:下午5:13
 **/
public class ReactiveStreamTest {

    public static void main(String[] args) {

        SubmissionPublisher publisher = new SubmissionPublisher();

        Flow.Subscriber<String> stringSubscriber = new Flow.Subscriber<>() {

            Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println(Thread.currentThread().getId()+" onSubscribe 被调用");
                this.subscription.request(10);
            }

            @Override
            public void onNext(String s) {
                System.out.println(Thread.currentThread().getId()+" onNext 被调用，接收到新的处理请求:"+s);
                subscription.request(10);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(Thread.currentThread().getId()+" onError 被调用，throwable："+throwable);
            }

            @Override
            public void onComplete() {
                System.out.println(Thread.currentThread().getId()+" onComplete 被调用");
            }
        };

        publisher.subscribe(stringSubscriber);

        /*Stream.generate(UUID::randomUUID).limit(50).forEach(a -> {
            publisher.submit(a);
        });*/

        for(int i=0; i<500; i++) {
            long threadId =  Thread.currentThread().getId();
            System.out.println(threadId+" 发布新消息："+i);
            publisher.submit(i+"");
        }

        long threadId =  Thread.currentThread().getId();
        System.out.println(threadId+" 我是主线程 我又开始做其他事情了");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
