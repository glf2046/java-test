package com.lefeng.others;

import java.util.Date;

public class Millinanoseconds {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date().toInstant().getNano());
        System.out.println(new Date().toInstant().getNano());
        System.out.println(new Date().toInstant().getNano());

        long l1 = System.nanoTime();
        Thread.sleep(3);

        long l2 = System.nanoTime();
        System.out.println(l2 -l1);

        long l3 = System.currentTimeMillis();
        Thread.sleep(2);
        long l4 = System.currentTimeMillis();

        System.out.println(l4 -l3);
    }
}
