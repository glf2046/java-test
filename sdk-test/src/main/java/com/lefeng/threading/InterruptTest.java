package com.lefeng.threading;

public class InterruptTest {
    public static void main(String[] args) {
        Thread thread2 = new Thread(){
            //these code will be part of the constructor instead of 'run' method.
            {
                try {
                    Thread.sleep(2000);
                    System.out.println("A2");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    System.out.println("B2");
                }
            }

            @Override
            public void run(){
                System.out.println("run method");
            }
        };

        thread2.start();
        thread2.interrupt();
    }
}
