package com.lefeng.ThreadingTest;

import java.util.concurrent.atomic.AtomicLong;

public class TooMuchThreads implements Runnable {

    AtomicLong atomicLong = new AtomicLong(0);

    public static void main(String[] args) {

            final TooMuchThreads tooMuchThreads = new TooMuchThreads();



        while (true){
            Thread thread = new Thread(tooMuchThreads);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicLong.incrementAndGet();
    }
}
