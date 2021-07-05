package com.lefeng.threading.automic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntTest {

    public static void main(String[] args) {
        test2();
    }

    private static void test2(){
        int[] array = {1, 2, 3};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);
        atomicIntegerArray.getAndAdd(0, 3);
        System.out.println(atomicIntegerArray.get(0));
    }

    private static void test1(){
        AtomicInteger atomicInteger = new AtomicInteger(1);

        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());;
    }
}
