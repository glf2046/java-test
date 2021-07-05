package com.lefeng.ThreadingTest.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalHashCodeTest {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private volatile int value;

    public ThreadLocalHashCodeTest(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        ThreadLocalHashCodeTest test = new ThreadLocalHashCodeTest(0);
        for (int i = 0; i < 50000; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.threadLocal.set(String.valueOf(finalI));
                    test.value = finalI;
                    test.f1();
                }
            }).start();
        }
    }

    private Map<Integer, Integer> map = new HashMap<>();

    private void f1(){
//        System.out.println(Thread.currentThread().getId() + "," +  threadLocal.get());
//        System.out.println(Thread.currentThread().getId() + "," +  value);
        if (!map.containsKey(value)) {
            map.put(value, 1);
        } else {
            System.out.println("duplicated: " + value);
        }
    }
}
