package com.lefeng.others;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Fa extends RecursiveTask<Integer> {
    final int n;

    TransferQueue transferQueue;
    ArrayBlockingQueue abq;
    ReentrantReadWriteLock a;
    AtomicInteger atomicInteger;
    Stack<Integer> stack;
    Queue queue;
    Fa(int n) {
        this.n = n;
    }
    private int compute(int small) {
        final int[] results = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        return results[small];
    }
    public Integer compute() {
        if (n <= 10) {
            return compute(n);
        }
        Fa f1 = new Fa(n - 1);
        Fa f2 = new Fa(n - 2);
        System.out.println("fork new thread for " + (n - 1));
        f1.fork();
        System.out.println("fork new thread for " + (n - 2));
        f2.fork();
        return f1.join() + f2.join();
    }
}
