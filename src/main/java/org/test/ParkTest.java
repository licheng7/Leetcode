package org.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/5/20
 * Time:下午4:08
 **/
public class ParkTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(
                () -> {
                    for(int i=0; i<10; i++) {
                        try {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getId()+"  t1  "+i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(
                () -> {
                    for(int i=0; i<10; i++) {
                        try {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getId()+"  t2  "+i);
                            if(i == 3) {
                                LockSupport.park();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        t2.setDaemon(true);
        t2.start();

        System.out.println("main end1");

        LockSupport.park(Thread.currentThread());


    }
}
