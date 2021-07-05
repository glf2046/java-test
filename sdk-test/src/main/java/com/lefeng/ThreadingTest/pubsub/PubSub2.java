package com.lefeng.ThreadingTest.pubsub;

import java.util.ArrayList;
import java.util.List;

public class PubSub2 {

    private static List<Integer> queue = new ArrayList<>(100);

    public static void main(String[] args) throws InterruptedException {
        Pub2 pub = new Pub2(queue);
        Pub2 pub2 = new Pub2(queue);
        Sub2 sub = new Sub2(queue);
        Sub2 sub2 = new Sub2(queue);

        pub.start();
//        pub2.start();
        sub.start();
        sub2.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("active thread count: " + Thread.activeCount());
        pub.stop();
        Thread.sleep(2000);
//        System.out.println("active thread count: " + Thread.activeCount());
//        pub2.stop();
        System.out.println("active thread count: " + Thread.activeCount());

        sub.stop();
        System.out.println("active thread count: " + Thread.activeCount());

        sub2.stop();
        System.out.println("active thread count: " + Thread.activeCount());

        System.out.println("completed");
    }
}

class Pub2 {

    private final List<Integer> queue;
    private boolean running = true;
    private Thread thread;

    public Pub2(List<Integer> queue) {
        this.queue = queue;
    }

    public void start() {
        thread = new Thread(() -> {
            int i = 0;
            while (running) {
                synchronized (queue) {
                    System.out.println("thread: " + Thread.currentThread().getId() + ", pub acquired lock");
                    int count = 0;
                    if (queue.size() > 0) {
                        try {
                            System.out.println("thread: " + Thread.currentThread().getId() + ", pub wait and release lock");
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("pub thread: " + Thread.currentThread().getId() + " quiting wait status");
                            break;
                        }
                    }

                    while (queue.size() < 1) {
                        queue.add(++i);
                        System.out.println("Thread: " + Thread.currentThread().getId() + ", produced: " + i);
                    }
                    queue.notifyAll();
                    System.out.println("thread: " + Thread.currentThread().getId() + ", notified all");
//                    if (queue.size() < 100) {
//                        queue.add(++i);
//                        System.out.println("produced item: " + i);
//                    } else {
//                        try {
//                            queue.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                }
                System.out.println("Thread: " + Thread.currentThread().getId() + ", pub released lock");
            }
        });

        thread.start();
    }

    public void stop() {
        running = false;
        if (thread != null && thread.isAlive()) {
            System.out.println("pub thread: " + thread.getId() + ", is still running, interrupting it ...");
            thread.interrupt();
        }
    }
}

class Sub2 {

    private final List<Integer> queue;
    private boolean running = true;
    private Thread thread;

    public Sub2(List<Integer> queue) {
        this.queue = queue;
    }

    public void start() {
        thread = new Thread(() -> {
            while (running) {
                synchronized (queue) {
                    System.out.println("Thread: " + Thread.currentThread().getId() + ", sub acquired lock");
                    if (queue.size() <= 0) {
                        try {
                            System.out.println("Thread: " + Thread.currentThread().getId() + ", sub wait and release lock");
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("sub thread: " + Thread.currentThread().getId() + " quiting wait status");
                            break;
                        }
                    }

                        int item = queue.remove(0);
                        System.out.println("Thread: " + Thread.currentThread().getId() + ", consumed item : " + item);

                    queue.notifyAll();
                    System.out.println("Thread: " + Thread.currentThread().getId() + ", notified all");
//                    if (queue.size() > 0) {
//                        int item = queue.remove(0);
//                        System.out.println("consumed item : " + item);
//                    } else {
//                        queue.notifyAll();
//                    }
                }
                System.out.println("Thread: " + Thread.currentThread().getId() + ", sub released lock");
            }
        });
        thread.start();
    }

    public void stop() {

        while (queue.size() > 0) {
            try {
                System.out.println("consuming left items...");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        running = false;
        System.out.println("not consumed item count: " + queue.size());

        if (thread != null && thread.isAlive()) {
            System.out.println("sub thread: " + thread.getId() + ", is still running, interrupting it ...");
            thread.interrupt();
        }
    }
}
