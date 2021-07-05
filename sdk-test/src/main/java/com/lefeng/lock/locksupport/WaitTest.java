package com.lefeng.lock.locksupport;

import java.util.ArrayList;
import java.util.List;

public class WaitTest {
    public static void main(String[] args) {

        final List<String> queue = new ArrayList<>();

        queue.add("item1");

        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 20; i++) {
                    System.out.print(i + " ");
                    if (i == 9) {
                        try {
                            System.out.println("");
                            System.out.println("t1 releasing lock");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("t2 acquired lock");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Java技术栈");
                lock.notifyAll();
            }
        });

        t1.start();
        t2.start();
    }
}
