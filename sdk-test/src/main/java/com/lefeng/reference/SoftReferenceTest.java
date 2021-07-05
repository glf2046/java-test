package com.lefeng.reference;

import java.lang.ref.SoftReference;
import java.util.Arrays;

/**
 * @author guff
 * @since 2020-03-08 22:59
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[20*1024*1024]);

        System.out.println(softReference.hashCode());
        System.out.println(softReference.get());
        System.out.println(softReference.get().hashCode());

        //当内存不够用的时候，gc会自动的回收这部分空间
        byte[] bytes2 = new byte[20*1024*1024];

        System.out.println(softReference.hashCode());
        System.out.println(softReference.get());
        System.out.println(softReference.get().hashCode());


        System.out.println("#########");
//        System.out.println(Arrays.hashCode(bytes2));
    }
}
