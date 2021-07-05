package com.lefeng.ThreadingTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guff
 * @since 2020-01-30 21:05
 */
public class IntervalOutputCharsTest {

    public static void main(String[] args) {

        char[] charsA = "1234567".toCharArray();
        char[] charsB = "ABCDEFG".toCharArray();

        lockCondition(charsA, charsB);
    }

    private static Thread t1 = null;
    private static Thread t2 = null;

    private static final Object Lock = new Object();
    private static Flag F = IntervalOutputCharsTest.Flag.F1;

    private static BlockingQueue<String> BlockingQueue1 = new ArrayBlockingQueue<>(1);
    private static BlockingQueue<String> BlockingQueue2 = new ArrayBlockingQueue<>(1);

    private static void lockCondition(char[] charsA, char[] charsB) {

        ReentrantLock reentrantLock = new ReentrantLock();

        Condition condition1 = reentrantLock.newCondition();

        Condition condition2 = reentrantLock.newCondition();

        new Thread(() -> {

            try {
                reentrantLock.lock();

                for (char c : charsA){
                    System.out.println(c);
                    condition2.signal();
                    condition1.await();
                    condition1.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }


        }).start();


        new Thread(() -> {

            try {
                reentrantLock.lock();

                for (char c : charsB){
                    System.out.println(c);
                    condition1.signal();
                    condition2.await();
                    condition1.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        }).start();


    }

    private static void pipedStream(char[] charsA, char[] charsB) {
        //ignored, normally not used on production env
    }

    private static void blockingQueue(char[] charsA, char[] charsB) {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsA) {
                    try {
                        BlockingQueue1.put("ok");
                        System.out.println(c);
                        BlockingQueue2.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsB) {
                    try {
                        BlockingQueue2.put("ok");
                        System.out.println(c);
                        BlockingQueue1.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void spinLock(char[] charsA, char[] charsB) {

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsA) {
                    while (F != Flag.F1) {
                    }
                    System.out.println(c);
                    F = Flag.F2;
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsB) {
                    while (F != Flag.F2) {
                    }
                    System.out.println(c);
                    F = Flag.F1;
                }
            }
        });

        t1.start();
        t2.start();
    }

    static enum Flag {
        F1, F2;
    }

    private static void waitNotify(char[] charsA, char[] charsB) {
        t1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (Lock) {
                    for (char c : charsA) {
                        System.out.println(c);
                        Lock.notify();
                        try {
                            Lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock) {
                    for (char c : charsB) {
                        try {
                            Lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(c);
                        Lock.notify();
                    }
                }
            }
        });

        t2.start();
        t1.start();
    }

    private static void lockSupport(char[] charsA, char[] charsB) {

        t1 = new Thread(() -> {
            for (char c : charsA) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (char c : charsB) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
