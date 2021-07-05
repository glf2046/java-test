package com.lefeng.threading.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockTest {

    public static void main(String[] args){
        test();
    }

    private static final ReentrantLock lock = new ReentrantLock();
    private static final AtomicInteger ai = new AtomicInteger(0);

    public static void test(){
        try {
            lock.lock();
            int count = ai.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " acquired lock already, lock count=" + count);

            if(count < 10) {
                //Thread calls the method again to start from beginning before releasing the lock.
                //it actually can re-enter the lock multiple times.
                test();
            }
        } finally {
            System.out.println("unlocking");
            lock.unlock();
        }
    }
}
