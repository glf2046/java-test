package com.lefeng.ThreadingTest.DaemonThread;

public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
            System.out.println("hello world");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.setDaemon(true);
        t.start();
    }
}
