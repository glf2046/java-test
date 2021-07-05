package com.lefeng.primitivetypes.ex;

public class AutoBoxing {
    public static void main(String[] args) {
        test(100);
        test(new Integer(200));
    }

    public static void test(Integer iObject) {
        System.out.println("Integer=" + iObject);
    }

    public static void test(long iObject) {
        System.out.println("long=" + iObject);
    }

//    public static void test(int iValue) {
//        System.out.println("int=" + iValue);
//    }
}
