package com.lefeng.test.syntax;

/**
 * @author guff
 * @since 2019-05-2:33 PM
 */
public class Boxing {

    private static final int COUNT = 1000000000;

    public static void main(String[] args) {
//        testAutoboxing();
//        testUnboxing();
//        testChangeToObject();
//        testChangeToData();
//        testNormal();
//        testNormal1();

        System.out.println("#######");
        testAutoUnBoxingWhenCaculation();
    }

    public static void testIntegerCache(){
        Integer i1 = 100;
        Integer i2 = 100;

        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }

    public static void testDoubleCache(){
        Double i1 = 100D;
        Double i2 = 100D;

        Double i3 = 200D;
        Double i4 = 200D;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }

    public static void testAutoUnBoxingWhenCaculation() {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;

        System.out.println(i3 == (i1+i2));
    }

    public static void testAutoboxing() {
        long start = System.currentTimeMillis();
        Integer result = 0;
        for (int i = 0; i < COUNT; i++) {
            result = i; // autoboxing
        }
        long end = System.currentTimeMillis();
        System.out.println("autoboxing use time is： " + (end - start) + "ms");
    }

    public static void testUnboxing() {
        int result = 0;
        long start = System.currentTimeMillis();
        for (Integer i = 0; i < COUNT; i++) {
            result = i;
        }
        long end = System.currentTimeMillis();
        System.out.println("unboxing use time is： " + (end - start) + "ms");
    }

    public static void testChangeToObject() {
        Integer result = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            result = (Integer) i;
        }
        long end = System.currentTimeMillis();
        System.out.println("change to object use time is: " + (end - start) + "ms");
    }

    public static void testChangeToData() {
        int result = 0;
        long start = System.currentTimeMillis();
        for (Integer i = 0; i < COUNT; i++) {
            result = i.intValue();
        }
        long end = System.currentTimeMillis();
        System.out.println("change to data use time is: " + (end - start) + "ms");
    }

    public static void testNormal() {
        int result = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            result = i;
        }
        long end = System.currentTimeMillis();
        System.out.println("normal use time is： " + (end - start) + "ms");
    }

    public static void testNormal1() {
        Integer result = 0;
        long start = System.currentTimeMillis();
        for (Integer i = 0; i < COUNT; i++) {
            result = i;
        }
        long end = System.currentTimeMillis();
        System.out.println("normal1 use time is： " + (end - start) + "ms");
    }
}
