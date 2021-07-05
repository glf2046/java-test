package com.lefeng.string;

import java.net.SocketOptions;

/**
 * @author guff
 * @since 2020-05-21 19:26
 */
public class StaticTest {

    //    static int anInt = 0;
    static StringBuilder anInt = new StringBuilder();

    public static void main(String[] args) {
//        System.out.printf(String.valueOf(SocketOptions.SO_RCVBUF));
        processString();
    }

    static void processString(){
        long start = System.currentTimeMillis();
//        String anInt = "";
//        StringBuilder anInt = new StringBuilder();
        for (int i = 0; i < 50000000; i++) {
            anInt.append(i);
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    static void processInt(){
        long start = System.currentTimeMillis();
        int anInt = 0;
        for (int i = 0; i < 1000000000; i++) {
            anInt++;
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
