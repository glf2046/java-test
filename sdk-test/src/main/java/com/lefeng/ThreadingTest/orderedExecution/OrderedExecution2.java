package com.lefeng.ThreadingTest.orderedExecution;

public class OrderedExecution2 {
    private static int count = 0;
    private static volatile boolean running = true;

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();

        Thread t1 = new Thread(() -> {
            while (running) {
                synchronized (lock1) {
                    try {
                        System.out.println("t1 waiting");
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (++count < 10) {
                        System.out.println("t1: " + count);
                    } else {


                        running = false;
                    }

                    synchronized (lock2) {
                        lock2.notify();
                    }
                }
            }

            synchronized (lock2) {
                System.out.println("lock2 unlocking form t1");
                lock2.notify();
                System.out.println("lock2 unlocked form t1");
            }

            synchronized (lock3) {
                System.out.println("lock3 unlocking form t1");
                lock3.notify();
                System.out.println("lock3 unlocked form t1");
            }
        }
        );

        Thread t2 = new Thread(() -> {
            while (running) {
                synchronized (lock2) {
                    try {
                        System.out.println("t2 waiting");
                        lock2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (++count < 10) {
                        System.out.println("t2: " + count);
                    } else {

                        running = false;
                    }

                    synchronized (lock3) {
                        lock3.notify();
                    }
                }
            }


            synchronized (lock1) {
                System.out.println("lock1 unlocking form t2");
                lock1.notify();
                System.out.println("lock1 unlocked form t2");
            }

            synchronized (lock3) {
                System.out.println("lock3 unlocking form t2");
                lock3.notify();
                System.out.println("lock3 unlocked form t2");
            }
        }
        );

        Thread t3 = new Thread(() -> {
            while (running) {
                synchronized (lock3) {
                    try {
                        System.out.println("t3 waiting");
                        lock3.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (++count < 10) {
                        System.out.println("t3: " + count);
                    } else {

                        running = false;
                    }

                    synchronized (lock1) {
                        lock1.notify();
                    }
                }
            }

            synchronized (lock1) {
                System.out.println("lock1 unlocking form t3");
                lock1.notify();
                System.out.println("lock1 unlocked form t3");
            }

            synchronized (lock2) {
                System.out.println("lock2 unlocking form t3");
                lock2.notify();
                System.out.println("lock2 unlocked form t3");
            }
        }
        );

        t1.start();
        t2.start();
        t3.start();

        synchronized (lock1) {
            lock1.notify();
        }
    }
}
