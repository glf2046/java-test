package com.lefeng.timer;

public class TimerTestOne extends Thread {
    private static boolean flag = false;

    public void run(){
        while(!flag){
//            System.out.println("running...");
        }
    }

    public static void main(String[] args) throws Exception{
        new TimerTestOne().start();
        Thread.sleep(100);
        flag = true;
    }
}
