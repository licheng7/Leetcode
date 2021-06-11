package org.test;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/5/21
 * Time:下午5:47
 **/
public class FluxTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList(new String[]{"a", "b", "c"});

        Flux f = Flux.fromIterable(list)
                .map(a -> {
                    System.out.println(Thread.currentThread().getId()+" "+a);
                    return a+"-";
                })
                .map(a -> {
                    System.out.println(Thread.currentThread().getId()+" "+a);
                    return a+"-";
                })
                .flatMap(a -> {
                    System.out.println(Thread.currentThread().getId()+"  "+a);
                    return Flux.empty();
                });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        f.subscribe((a) -> {System.out.println(Thread.currentThread().getId()+" "+a);});
    }
}
