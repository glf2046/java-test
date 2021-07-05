package com.lefeng.lock.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest1 {

    private static Thread mainThread;

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(mainThread + " start ta");
        ta.start();

        System.out.println(mainThread + " block");
        // 主线程阻塞
        LockSupport.park(mainThread);

        System.out.println(mainThread + " continue");
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " is doing some work");
            // 唤醒“主线程”
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up");
            LockSupport.unpark(mainThread);
            //System.out.println("unparked mainthread");
        }
    }
}
