package com.lefeng.exception;

public class ExceptionTableTest {

    public static void simpleTryCatch() {
        try {
            testNPE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testNPE() {
        System.out.println("hello");
    }
}
