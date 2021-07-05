package com.lefeng.ThreadingTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author guff
 * @since 2020-01-30 21:05
 */
public class IntervalOutputCharsTest2 {

    public static void main(String[] args) throws InterruptedException {

        char[] charsA = "1234567".toCharArray();
        char[] charsB = "ABCDEFG".toCharArray();

        AtomicReference<CountDownLatch> countDownLatchA = new AtomicReference<>(new CountDownLatch(1));
        AtomicReference<CountDownLatch> countDownLatchB = new AtomicReference<>(new CountDownLatch(1));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsA) {
                    try {
                        countDownLatchA.get().await();
                        System.out.println(c);
                        //在countDownLatchA下次调用await()之前，要重新设定值
                        countDownLatchA.set(new CountDownLatch(1));
                        //唤醒Thread2
                        countDownLatchB.get().countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsB) {
                    try {
                        countDownLatchB.get().await();
                        System.out.println(c);
                        countDownLatchB.set(new CountDownLatch(1));
                        countDownLatchA.get().countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2.start();

        countDownLatchA.get().countDown();

        t1.join();
        t2.join();
    }
}