package com.lefeng.lock.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranctLockTest {
    private static int count;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

//        Thread t1 = new Thread(() -> {
//            try {
//                lock.lock();
//                condition.await();
//                count++;
//            } catch(Exception exception){
//
//            } finally {
//                lock.unlock();
//            }
//        });
//
//        t1.start();


        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println("thread: " + Thread.currentThread().getId() + " acquired lock");
                    count++;
                } catch(Exception ignored){

                } finally {
                    lock.unlock();
                    System.out.println("thread: " + Thread.currentThread().getId() + " released lock");
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(count);
    }
}
