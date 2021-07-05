package com.lefeng.threading;

public class StopThreadWithSignal {

    private static volatile boolean stop;
    private static int i = 0;

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!stop) {
                    System.out.println(i++);
                }
            }
        });

        t.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("main thread interuptted");
        }


        shutDown();

        System.out.println("main thread finished");
    }


    private static void shutDown(){
        stop = true;
    }
}
