package com.lefeng.lock.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        readWriteLock.readLock().tryLock();
        readWriteLock.readLock().tryLock(0, TimeUnit.SECONDS);
        readWriteLock.readLock().unlock();
        readWriteLock.writeLock().tryLock();
        readWriteLock.writeLock().tryLock(0, TimeUnit.SECONDS);
        readWriteLock.writeLock().unlock();
    }
}
