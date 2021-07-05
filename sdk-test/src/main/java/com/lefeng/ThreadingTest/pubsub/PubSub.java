package com.lefeng.ThreadingTest.pubsub;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PubSub {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Pub pub  = new Pub(queue);
        Sub sub = new Sub(queue);


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
}

class Pub {

    private BlockingQueue<Integer> queue;
    private boolean running = false;

    public Pub(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void start() {
        new Thread(()->{
            running = true;
            int i = 0;
            while (running) {
                try {
                    queue.put(++i);
                    System.out.println("produced item: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stop(){
        running = false;
    }
}

class Sub {

    private BlockingQueue<Integer> queue;
    private boolean running = false;

    public Sub(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void start(){
        new Thread(()->{
            running = true;
            while(running){
                try {
                    int item = queue.take();
                    System.out.println("consumed item : " + item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stop(){

        while(queue.size() > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        running = false;
        System.out.println("not consumed item count: " + queue.size());
    }
}

