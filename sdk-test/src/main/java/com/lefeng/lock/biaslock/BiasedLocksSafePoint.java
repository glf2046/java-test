package com.lefeng.lock.biaslock;

import java.util.concurrent.locks.LockSupport;

public class BiasedLocksSafePoint {
    //synchronized on Class
    private synchronized void contend() {
        LockSupport.parkNanos(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        BiasedLocksSafePoint biasedLocksSafePoint = new BiasedLocksSafePoint();
        biasedLocksSafePoint.hashCode();
        System.identityHashCode(biasedLocksSafePoint);
        Thread.sleep(5_000);

        for (int i = 0; i < 10; i++) {
            System.identityHashCode(biasedLocksSafePoint);
            biasedLocksSafePoint.hashCode();

            new Thread(biasedLocksSafePoint::contend).start();
        }
    }
}
