package com.lefeng.test.syntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guff
 * @since 2019-05-1:52 PM
 */
public class ThreadLocalTest {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return atomicInteger.getAndIncrement();
        }
    };

    public int get(){
        return threadId.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 10; i++) {
//            service.execute(new Runnable() {
//                public void run() {
//                    System.out.println(test.get());
//                }
//            });
//        }
//
//        Thread.sleep(100);
//        System.out.println("###########");
//
//        for (int i = 0; i < 10; i++) {
//            service.execute(new Runnable() {
//                public void run() {
//                    System.out.println(test.get());
//                }
//            });
//        }

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread() {
                @Override
                public void run() {
                    System.out.println(test.get());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("recheck result: "  + test.get());

                }
            });
        }

        for (int i = 0; i < 10; i++) {
            threadList.get(i).start();
        }

        Thread.sleep(5000);
        System.out.println("###########");
    }
}
