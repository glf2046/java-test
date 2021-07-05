package com.lefeng.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    private int value1 = 1;
    private int value2 = 2;
    private String state = "hello world";

    public static void main(String[] args) {
        Unsafe unsafe = UnSafeUtil.getUnsafe();
        try {
            long offset1 = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("value1"));
            long offset2 = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("value2"));
            long offset3 = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
            unsafe.storeFence();

            UnsafeTest unsafeTest = new UnsafeTest();

            System.out.println(unsafeTest.value1);
            System.out.println(unsafeTest.state);

            unsafe.compareAndSwapInt(unsafeTest, offset1, 1, 10);
            unsafe.compareAndSwapObject(unsafeTest, offset3, "hello world", "hello 123");

            System.out.println(unsafeTest.value1);
            System.out.println(unsafeTest.state);

            System.out.println("##############");


            System.out.println(offset1);
            System.out.println(offset2);
            System.out.println(offset3);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

