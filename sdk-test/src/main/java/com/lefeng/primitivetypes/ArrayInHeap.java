package com.lefeng.primitivetypes;

import java.util.ArrayList;

public class ArrayInHeap {
    public static void main(String[] args) throws InterruptedException {
//        ArrayList arrayList = new ArrayList();
//        for (int i = 0; i < 1000000; i++) {
//            arrayList.add(new int[10][10]);
//        }

        Thread.sleep(10000);


        foo();

        Thread.sleep(30000);
    }

    public static void foo(){
        int[][] list = new int[10000][10000];
    }
}
