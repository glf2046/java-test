package com.lefeng.threading.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {

        Thread t3 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 3 waiting on countDownLatch....");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(countDownLatch.getCount());

                System.out.println("thread 3 resumed and finished work....");
            }
        }));

        t3.start();

        Thread t1 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1 finished work, count down 1");
                System.out.println(countDownLatch.getCount());

                countDownLatch.countDown();
            }
        }));

        t1.start();

        Thread t2 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 2 finished work, count down 1");
                System.out.println(countDownLatch.getCount());

                countDownLatch.countDown();
            }
        }));

        t2.start();
    }
}
