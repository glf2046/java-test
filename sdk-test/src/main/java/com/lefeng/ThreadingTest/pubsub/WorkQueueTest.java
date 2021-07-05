package com.lefeng.ThreadingTest.pubsub;

import java.util.LinkedList;
import java.util.List;

public class WorkQueueTest extends WorkQueue {

    public static void main(String[] args) {
        WorkQueue queue = new WorkQueueTest();
        queue.start();

        queue.enqueue("item1");
//        queue.enqueue("item2");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        queue.requestStop();
    }

    @Override
    protected void process(String item) {
        Thread thread = new Thread(() -> enqueue("item3"));
        thread.start();

        //If calls thread.join there, then this method won't exit until 'thread' exit
        //somehow if this method won't exit, then the outer thread which invokes 'process" still keeps the lock on 'queue'
        //so 'thread' won't be able to acquire the lock on 'queue', so there is a deadlock.
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("processing: " + item);
    }
}

abstract class WorkQueue extends Thread {

    private volatile boolean stop = false;

    private final List<String> queue = new LinkedList<>();

    protected void enqueue(String item) {
        synchronized (queue) {
            queue.add(item);
            queue.notify();
        }
    }

    @Override
    public void run() {

        while (!stop) {

            synchronized (queue) {

                if (!queue.isEmpty()) {
                    String item = queue.remove(0);
                    if (item != null) {
                        process(item);
                    }
                } else {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }
    }

    protected abstract void process(String item);

    public void requestStop() {
        synchronized (queue) {
            stop = true;
            interrupt();
        }
    }
}
