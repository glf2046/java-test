package com.lefeng.ThreadingTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guff
 * @since 2020-01-30 21:05
 */
public class IntervalOutputCharsTest3 {

    public static void main(String[] args) throws InterruptedException {

        char[] charsA = "1234567".toCharArray();
        char[] charsB = "ABCDEFG".toCharArray();

        ReentrantLock lock = new ReentrantLock(true);
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsA) {
                    lock.lock();

                    try{
                        System.out.println(c);
                        conditionB.signal();
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsB) {
                    lock.lock();
                    try{
                        System.out.println(c);
                        conditionA.signal();
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        t2.start();

//        lock.lock();
//        try{
//            conditionA.signal();
//        } finally {
//            lock.unlock();
//        }

        t1.join();
        t2.join();
    }
}