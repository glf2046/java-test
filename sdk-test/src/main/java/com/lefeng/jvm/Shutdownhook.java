package com.lefeng.jvm;

public class Shutdownhook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing shutdown hook...");
            }
        }));

        System.out.println("Man thread doing something...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
            e.printStackTrace();
        }
    }
}
