package com.lefeng.ThreadingTest.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.execute(() -> {
                final int j = finalI;
                try {
                    if (j == 4) {
                        System.out.println("some exp");
                        throw new Exception("some exp");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    executorService.execute(() -> System.out.println("hello world"));
                }
            });
        }

//        executorService.shutdown();
//
//        for (int i = 0; i < 5; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                final int j = finalI;
//                try {
//                    if (j == 4) {
//                        System.out.println("some exp");
//                        throw new Exception("some exp");
//                    } else {
//                        Thread.sleep(3000);
//                        System.out.println("3000 done");
//                    }
//                } catch (Exception e) {
//                    System.out.println("exp caught: {} " + e);
//                    e.printStackTrace();
//                }
//            }).start();
//        }

//        Thread.sleep(4000);
    }
}
