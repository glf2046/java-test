package com.lefeng.lock.mutex;

import sun.awt.Mutex;

public class MutexSun {
    public static void main(String[] args) {
        Mutex mutex = new Mutex();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                mutex.lock();
                System.out.println("thread: " + Thread.currentThread().getId() + " is doing some work");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mutex.unlock();

            }).start();

        }
    }
}
