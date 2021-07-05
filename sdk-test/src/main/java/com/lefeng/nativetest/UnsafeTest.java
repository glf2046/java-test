package com.lefeng.nativetest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    public static void main(String[] args) {
        long size = 30*1024*1024L;
        long address = 0;

        Unsafe unsafe = getUnsafe();
        if (unsafe != null) {
            address = unsafe.allocateMemory(size);
        }

        if(address == 0)
            return;

        try {
            System.out.println("Unsafe address: " + address);
            System.out.println("Address Hex format: " + Long.toHexString(address));
            for (int i = 0; i < 100; i++) {
                unsafe.putByte(address + i, (byte)123);
                if(unsafe.getByte(address +i) != 123){
                    System.out.println("Failed at offset = " + i);
                }
            }
        } finally {
            unsafe.freeMemory(address);
        }
    }

    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);

        } catch (Exception e) {
        }
        return null;
    }

    private void testMaxMemory(){
        byte[] bytes = new byte[Integer.MAX_VALUE/2];
        System.out.println(Integer.MAX_VALUE/1024/1024);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
