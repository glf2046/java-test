package com.lefeng.threadlocaltest;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueThreadIdGenerator {
    private static final AtomicInteger uniqueId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> uniqueNum = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return uniqueId.getAndIncrement();
        }
    };

    public static int getCurrentThreadId(){
        return uniqueNum.get();
    }

    public static void main(String[] args) {
        Thread t1 =new Thread(){
            @Override
            public void run() {
                System.out.println("11:" + UniqueThreadIdGenerator.getCurrentThreadId());
                System.out.println("12: " + UniqueThreadIdGenerator.getCurrentThreadId());
            }
        };

        Thread t2 =new Thread(){
            @Override
            public void run() {
                System.out.println("21: " + UniqueThreadIdGenerator.getCurrentThreadId());
                System.out.println("22: " + UniqueThreadIdGenerator.getCurrentThreadId());
            }
        };

        Thread t3 =new Thread(){
            @Override
            public void run() {
                System.out.println("31: " + UniqueThreadIdGenerator.getCurrentThreadId());
                System.out.println("32: " + UniqueThreadIdGenerator.getCurrentThreadId());

            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}
