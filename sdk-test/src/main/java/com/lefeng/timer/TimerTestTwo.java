package com.lefeng.timer;

import java.util.concurrent.TimeUnit;

public class TimerTestTwo {
    public static boolean flag = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!flag){
                    System.out.println("running...");
                }
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                flag = true;
            }
        }).start();

    }
}
