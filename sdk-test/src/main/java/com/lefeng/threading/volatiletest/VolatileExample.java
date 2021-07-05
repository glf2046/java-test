package com.lefeng.threading.volatiletest;

public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
                example.writer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
                example.reader();
            }
        });

    }
    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;      // 1
        flag = true;    // 2 }
    }

    public void reader() {
        if (!flag) {    // 3
            System.out.println("flag is still false");

        }

        int i = a;  //4
        if (i != 1) {
            System.out.println("not equal to 1");
        }
    }
}
