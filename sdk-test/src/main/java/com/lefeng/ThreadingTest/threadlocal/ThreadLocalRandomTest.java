package com.lefeng.ThreadingTest.threadlocal;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author guff
 * @since 2020-08-13 14:33
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
//        也就是说int型整数相乘，结果只会保留低32位，高位会抛弃掉。所以num * 16L的值与0xffffffff做位与操作（即取后32位）就可以得到实际运算的结果了。
//
//        那么下面的这些语句有没有bug呢？
//
//        long MonthNanoSeconds1 = 30 * 24 * 3600 * 1000 * 1000;
//        long MonthNanoSeconds2 = 30 * 24 * 3600 * 1000 * 1000L;
//        将一个大的数赋值给long型变量，好像没什么问题。但是要注意到java是先计算右值，再赋值给long变量的。在计算右值的过程中（int型相乘）发生溢出，然后将溢出后截断的值赋给变量。而在第二行语句中由于java的运算规则从左到右，再与最后一个long型的1000相乘之前就已经溢出，所以结果也不对。正确的方式应该如下：
//
//        long MonthNanoSeconds = 30L * 24 * 3600 * 1000 * 1000;


        long MonthNanoSeconds1 = 30 * 24 * 3600 * 1000 * 1000;
        long MonthNanoSeconds2 = 30 * 24 * 3600 * 1000 * 1000L;
        long MonthNanoSeconds3 = 30 * 24 * 3600 * 1000 * 1000L;
        long MonthNanoSeconds4 = 30L * 24 * 3600 * 1000 * 1000L;

        System.out.println(30 * 24 * 3600 * 1000 * 1000);
        System.out.println(30 * 24 * 3600 * 1000 * 1000L);
        System.out.println(30L * 24 * 3600 * 1000 * 1000);

        byte b1 = 12;
        byte b2 = 13;
        System.out.println(b1 * b2);

        short s1 = 12;
        short s2 = 213;
        System.out.println(s1 * s2);

        char c1 = 12;
        char c2 = 13;
        System.out.println( c1 * c2);

        System.out.println("##################");
        int i3 = 123566234;
        System.out.println(i3 & 0xffffffff);
        System.out.println(i3 * 16F);

        System.out.println(MonthNanoSeconds1 == MonthNanoSeconds2);
        System.out.println(MonthNanoSeconds3 == MonthNanoSeconds2);
        System.out.println(MonthNanoSeconds4);

        long l1 = 181783497276652981L;
        long l2 = 8682522807148012L;
        long l3 = l1 * l2 * l2 * l2;

        System.out.println(l3);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000000; i1++) {
                    int r = random.nextInt();
                }
            }).start();
        }
        long end = System.currentTimeMillis();
        System.out.println("duration " + (end - start) );


        Random random1 = new Random();
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000000; i1++) {
                    int r = random1.nextInt();
                }
            }).start();
        }
        end = System.currentTimeMillis();
        System.out.println("duration " + (end - start) );
    }
}
