package com.lefeng.ThreadingTest.pubsub;

public class MyThread extends Thread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread(()->{
            System.out.println("thread id: " + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("work done");
        });

        myThread.start();
        try {
            myThread.wait1(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("program done");
    }

    public MyThread(Runnable runnable){
        super(runnable);
    }

    public synchronized void wait1() throws InterruptedException {
        wait1(0);
    }

    public synchronized void wait1(int i) throws InterruptedException {
     if(i == 0){
         while(isAlive()){
             wait(10);
         }
     }
    }
}
