package com.lefeng.CollectionTest.hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class HashtableTest {
    public static void main(String[] args) throws InterruptedException {
        //test1();
        test6HashMapWithAtomicInteger();
    }

    private static void test6HashMapWithAtomicInteger() throws InterruptedException {

        //Run 10 times
        for (int j = 0; j < 10; j++) {
            String key = "key";
            HashMap<String, AtomicInteger> hashMap = new HashMap<>();
            hashMap.put(key, new AtomicInteger(0));

            for (int i = 0; i < 200; i++) {
                new Thread(() -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    hashMap.get(key).incrementAndGet();
                }).start();
            }

            Thread.sleep(100);
            System.out.println(hashMap.get(key));
        }
    }

    private static void test5() throws InterruptedException {

        String key = "key";
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(key, 0);

        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = hashMap.get(key);
                hashMap.put(key, ++value);
            }).start();
        }

        Thread.sleep(100);
        System.out.println(hashMap.get(key));
    }


    private static void test2() throws InterruptedException {

        String key = "key";
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put(key, 0);

        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = hashtable.get(key);
                hashtable.put(key, ++value);
            }).start();
        }

        Thread.sleep(100);
        System.out.println(hashtable.get(key));
    }

    private static void test3() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        String key = "key";
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(key, 0);
        for (int i = 0; i < 200; i++) {
            int x = i;
            new Thread(() -> {
                try {
                    latch.await();
                    System.out.println(System.currentTimeMillis() + ", ing");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hashMap.put(key, x);
            }).start();
        }

        latch.countDown();
        System.out.println(System.currentTimeMillis() + ", begin");


        Thread.sleep(100);

        System.out.println(hashMap.get(key));
    }

    private static void test1() {
        Hashtable<Long, Boolean> hashtable = new Hashtable<>();
        hashtable.put(1L, true);
        hashtable.put(2L, true);
        hashtable.put(3L, true);
        hashtable.put(4L, true);
        hashtable.put(5L, true);

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                hashtable.put((long) i, true);
            }

        }).start();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                hashtable.get(1);
                System.out.println(System.currentTimeMillis() + ", processing: " + finalI);
            }).start();
        }
    }
}
