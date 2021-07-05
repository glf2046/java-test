package com.lefeng.ThreadingTest;

/**
 * @author guff
 * @since 2020-01-30 21:05
 */
public class IntervalOutputCharsTest4 {

    public synchronized void f1(char c){
        System.out.println(c);
        notify();
        try {
            System.out.println("t1 waiting...");
            //没有用while(!condition),存在：
            // 1. 虚假唤醒问题:使得线程没有收到 notify 时也能退出等待状态
            // 2. 唤醒者误唤醒当前线程问题（因为notify和notifyAll不能控制具体唤醒哪个线程，只要是wait状态都会被唤醒。
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
    public synchronized void f2(char c){
        System.out.println(c);
        notify();
        try {
            System.out.println("t2 waiting...");
            //没有用while(!condition),存在：
            // 1. 虚假唤醒问题:使得线程没有收到 notify 时也能退出等待状态
            // 2. 唤醒者误唤醒当前线程问题（因为notify和notifyAll不能控制具体唤醒哪个线程，只要是wait状态都会被唤醒。
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {

        char[] charsA = "1234567".toCharArray();
        char[] charsB = "ABCDEFG".toCharArray();
        IntervalOutputCharsTest4 intervalOutputCharsTest4 = new IntervalOutputCharsTest4();

        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsA) {
                    intervalOutputCharsTest4.f1(c);
                }

            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : charsB) {
                    intervalOutputCharsTest4.f2(c);
                }
            }
        });

        t2.start();

        t1.join();
        t2.join();
    }
}