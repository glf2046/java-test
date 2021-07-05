package com.lefeng.ThreadingTest.threadlocal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {

    private static CountDownLatch latch = new CountDownLatch(3);

    private ThreadLocalTest() {
    }

    public static void main(String[] args) throws InterruptedException {
       new ThreadLocalTest().test();
    }

    private synchronized void test() throws InterruptedException {
        ThreadLocal<String> local = new ThreadLocal<>();

        Key key = new Key("key1");
        LocalItem item = new LocalItem(key, local);

        Thread t1 = new Thread(item);

        Thread t2 = new Thread(item);

        Thread t3 = new Thread(item);

        t1.start();
        System.out.println(t1.isAlive());
//        t1.join();
        t1.interrupt();
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        Thread.sleep(10);

        t2.start();
        //t2.join();

//        while(t2.isAlive()){
//            t2.wait(10);
//        }

        Thread.sleep(10);

        t3.start();
        t3.join();
    }

    static class LocalItem implements Runnable {

        private AtomicInteger threadCount = new AtomicInteger();

        public Key getSharedValue() {
            return sharedValue;
        }

        public void setSharedValue(Key sharedValue) {
            this.sharedValue = sharedValue;
        }

        private Key sharedValue;

        public LocalItem(Key sharedValue, ThreadLocal<String> value) {
            this.sharedValue = sharedValue;
            this.value = value;
        }

        public LocalItem(Key sharedValue) {
            this.sharedValue = sharedValue;
        }

        public ThreadLocal<String> getValue() {
            return value;
        }

        public void setValue(ThreadLocal<String> value) {
            this.value = value;
        }

        private ThreadLocal<String> value;


        public void start() throws InterruptedException {
            int count = threadCount.incrementAndGet();
            System.out.println("thread count: " + count + ",  thread id: " + Thread.currentThread().getId());
            if(count == 2){
                value.set("local-1");
                sharedValue = new Key("shared-1");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw e;
            }

            System.out.println("local value: " + value.get());
            System.out.println("shared value: " + sharedValue.getValue());
            System.out.println("##################################");
        }

        @Override
        public void run() {
            try {
                start();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("thread: " + Thread.currentThread().getId() + " interrupted");
            }
            latch.countDown();
        }
    }

}

class Key {

    String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    Key(String value) {
        this.value = value;
    }
}


