package com.lefeng.ThreadingTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<Integer> {

    public static void main(String[] args) {

        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "'s i value " + i);
            if (i == 20) {
                new Thread(ft, " thread returning value ").start();

                try {
                    System.out.println("child thread return value:" + ft.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Override
    public Integer call() {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }

}
