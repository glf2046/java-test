package com.lefeng.unsafe;

import sun.misc.Unsafe;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class UnsafeParkTest {
    public static void main(String[] args) {
        Unsafe unsafe = UnSafeUtil.getUnsafe();
    }

    private AtomicBoolean atLocked = new AtomicBoolean(false);
    private Queue<Thread> waitingThreads = new ConcurrentLinkedQueue<>();

    public void lockRes() {
        Thread current = Thread.currentThread();
        waitingThreads.add(current);
        while (waitingThreads.peek() != current ||
                !atLocked.compareAndSet(false, true)) {
            LockSupport.park();
        }
        waitingThreads.remove();
    }

    public void unlockRes() {
        atLocked.set(false);
        LockSupport.unpark(waitingThreads.peek());
    }
}
