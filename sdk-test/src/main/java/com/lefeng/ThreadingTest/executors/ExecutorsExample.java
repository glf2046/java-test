package com.lefeng.ThreadingTest.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(ExecutorsExample::foo);
//        t.start();
//        t.join();
//        t.stop();
        for (int i = 0; i < 100; i++) {
            foo();
            Thread.sleep(10000);
        }
    }

    private static void foo() throws InterruptedException {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Creating a Runnable...");
        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());
        };

        System.out.println("Submit the task specified by the runnable to the executor service.");
        executorService.submit(runnable);
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        executorService = null;
    }
}
