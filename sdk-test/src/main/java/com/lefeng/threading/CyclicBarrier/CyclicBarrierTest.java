package com.lefeng.threading.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static CyclicBarrier barrier = new CyclicBarrier(2);
    public static void main(String[] args) {
        Thread t3 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 3 await on barrier");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 3 resumes and finished work");

            }
        }));

        t3.start();

        Thread t1 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1 await on barrier");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("thread 1 resumes and finished work");
            }
        }));

        t1.start();

        Thread t2 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 2 await on barrier");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 2 resumes and finished work");
            }
        }));

        t2.start();

        Thread t4 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 4 await on barrier");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 4 resumes and finished work");
            }
        }));

        t4.start();
    }
}
