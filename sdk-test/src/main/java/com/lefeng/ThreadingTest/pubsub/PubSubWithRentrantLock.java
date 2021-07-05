package com.lefeng.ThreadingTest.pubsub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PubSubWithRentrantLock {

    private static volatile List<Integer> queue = new ArrayList<>(100);
    static ReentrantLock lock = new ReentrantLock(true);
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    static Condition pubCondition = lock.newCondition();
    static Condition subCondition = lock.newCondition();

    public static void main(String[] args) {
        PubWithLock pub = new PubWithLock(queue);
        SubWithLock sub = new SubWithLock(queue);

        pub.start();
        sub.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pub.stop();
        sub.stop();
        System.out.println("completed");
    }

    static class PubWithLock implements Runnable {

        private final List<Integer> queue;
        private final int queueSizeLimit = 10;
        private volatile boolean running = true;

        public PubWithLock(List<Integer> queue) {
            this.queue = queue;
        }


        public void start() {
            running = true;
            new Thread(this).start();
        }

        public void stop() {
            running = false;
        }

        @Override
        public void run() {
            int i = 0;
            while (running) {
                try {
                    lock.lock();
                    System.out.println("Thread: " + Thread.currentThread().getId() + ", pub lock acquired at: " + System.nanoTime());

                    while (queue.size() > 0) {
                        try {
                            pubCondition.await();
                            System.out.println("pub awaits");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    while (queue.size() < queueSizeLimit) {
                        queue.add(++i);
                        System.out.println("produced item: " + i);
                    }
                    subCondition.signal();
                    System.out.println("sub signaled");
                } finally {
                    lock.unlock();
                    System.out.println("Thread: " + Thread.currentThread().getId() + ", pub lock released at: " + System.nanoTime());
                }
            }
        }
    }

    static class SubWithLock implements Runnable {

        private final List<Integer> queue;
        private volatile boolean running = false;
        //每次消费的个数
        private final int fetchCount = 3;

        public SubWithLock(List<Integer> queue) {
            this.queue = queue;
        }

        public void start() {
            running = true;
            new Thread(this).start();
        }

        public void stop() {

            //等待所有元素消费完成
            while (queue.size() > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            running = false;
            System.out.println("not consumed item count: " + queue.size());
        }

        @Override
        public void run() {
            while (running) {
                try {
                    lock.lock();
                    System.out.println("Thread: " + Thread.currentThread().getId() + ", sub lock acquired at: " + System.nanoTime());

                    while (queue.size() <= 0) {
                        System.out.println("sub awaits");
                        subCondition.await();
                    }

                    int count = 1;
                    //count++ <= fetchCount 是一个表达式，++放在后面，所以整个表达式结束之后count才会加1，如果放在前面，那么执行表达式的时候已经加1
                    while (queue.size() > 0 && count++ <= fetchCount) {
                        int item = queue.remove(0);
                        System.out.println("consumed item : " + item);
                    }
                    pubCondition.signal();
                    System.out.println("pub signaled");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("Thread: " + Thread.currentThread().getId() + ", sub lock released at: " + System.nanoTime());
                }
            }
        }
    }
}
