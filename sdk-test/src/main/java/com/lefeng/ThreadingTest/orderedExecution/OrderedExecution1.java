package com.lefeng.ThreadingTest.orderedExecution;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class OrderedExecution1 {
    private static int count = 0;

    public static void main(String[] args) {

        AtomicReference<CountDownLatch> latch1 = new AtomicReference<>(new CountDownLatch(1));
        AtomicReference<CountDownLatch> latch2 = new AtomicReference<>(new CountDownLatch(1));
        AtomicReference<CountDownLatch> latch3 = new AtomicReference<>(new CountDownLatch(1));

        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    latch1.get().await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (++count < 10)
                    System.out.println("thread:" + Thread.currentThread().getId() + "," + count);
                latch1.set(new CountDownLatch(1));
                latch2.get().countDown();
            }
        }
        );

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    latch2.get().await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (++count < 10)
                    System.out.println("thread:" + Thread.currentThread().getId() + "," + count);
                latch2.set(new CountDownLatch(1));
                latch3.get().countDown();
            }
        }
        );

        Thread t3 = new Thread(() -> {
            while (true) {
                try {
                    latch3.get().await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (++count < 10)
                    System.out.println("thread:" + Thread.currentThread().getId() + "," + count);
                latch3.set(new CountDownLatch(1));
                latch1.get().countDown();
            }
        }
        );

        t1.start();
        t2.start();
        t3.start();

        latch1.get().countDown();
    }
}
