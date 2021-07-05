package com.lefeng.jvm;

public class ShutdownHookTest implements Runnable {
    public static void main(String[] args) {

        final ShutdownHookTest tooMuchThreads = new ShutdownHookTest();

       

        int i = 0;
        while (i++ < 10){
            Thread thread = new Thread(tooMuchThreads);
            thread.setDaemon(true);
            thread.start();
        }
        //System.exit(0);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("work done " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
