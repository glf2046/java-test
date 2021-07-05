package com.lefeng.ThreadingTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guff
 * @since 2020-01-30 21:05
 */
public class IntervalOutputCharsTest5 {

    public static void main(String[] args) throws InterruptedException {

        char[] charsA = "1234567".toCharArray();
        char[] charsB = "ABCDEFG".toCharArray();

        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsA) {
                    lock.lock();
                    System.out.println(c);
                    condition.signal();
                    try{
                        System.out.println("t1 waiting...");
                        condition.await();
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
                    System.out.println(c);
                    condition.signal();
                    try{
                        System.out.println("t2 waiting...");
                        condition.await();
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