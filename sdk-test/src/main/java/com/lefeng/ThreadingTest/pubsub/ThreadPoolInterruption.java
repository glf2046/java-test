package com.lefeng.ThreadingTest.pubsub;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolInterruption {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 100,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));


        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(10000);
                    Thread.currentThread().join();
                    System.out.println("Thread : " + Thread.currentThread().getId() + " working");
                    System.out.println("Thread hashcode : " + Thread.currentThread().hashCode() + " working");
                } catch (InterruptedException e) {
                    System.out.println("Thread : " + Thread.currentThread().getId() + " interrupted");
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
