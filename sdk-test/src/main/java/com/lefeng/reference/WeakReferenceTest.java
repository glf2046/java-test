package com.lefeng.reference;

import java.lang.ref.WeakReference;

/**
 * @author guff
 * @since 2020-03-08 23:36
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<byte[]> bytes = new WeakReference<>(new byte[20 * 1024 * 1024]);

        System.out.println(bytes.get());
        System.out.println(bytes.get().hashCode());

        //不管堆内存是否够用，只要发生了GC（不管是minor gc还是full gc都会回收弱引用指向的对象空间
        System.gc();

        System.out.println(bytes.get());
        System.out.println(bytes.get().hashCode());
    }
}
