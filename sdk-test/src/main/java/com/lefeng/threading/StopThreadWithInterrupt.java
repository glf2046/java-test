package com.lefeng.threading;

public class StopThreadWithInterrupt {
    public static void main(String[] args) {
        Thread thread2 = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(2000);
                    System.out.println("A2");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    System.out.println("B2");
                }
            }
        };

        thread2.start();

        //If this thread is blocked in an invocation of the wait(), wait(long),
        // or wait(long, int) methods of the Object class, or of the join(), join(long), join(long, int), sleep(long),
        // or sleep(long, int), methods of this class, then its interrupt status will be cleared and it will receive an InterruptedException.
        thread2.interrupt();
    }
}
