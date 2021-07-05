package com.lefeng.CollectionTest.hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test2() {
        ConcurrentHashMap<Long, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1L, true);
        concurrentHashMap.put(2L, true);
        concurrentHashMap.put(3L, true);
        concurrentHashMap.put(4L, true);
        concurrentHashMap.put(5L, true);
    }

    private static void test1() {
        ConcurrentHashMap<Long, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1L, true);
        concurrentHashMap.put(2L, true);
        concurrentHashMap.put(3L, true);
        concurrentHashMap.put(4L, true);
        concurrentHashMap.put(5L, true);

        new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                synchronized (concurrentHashMap) {
                    concurrentHashMap.put((long) i, true);
                }
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                concurrentHashMap.get(1);
                System.out.println(System.currentTimeMillis() + ", processing: " + finalI);
            }).start();
        }
    }
}
