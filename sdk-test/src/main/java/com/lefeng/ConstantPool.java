package com.lefeng;

public class ConstantPool {
    public static void main(String[] args) {
        testFinalString();
    }

    private static void testIntern(){
        String a = new String("hello");
        String b = "hello";

        System.out.println( a==b);
        System.out.println( a.intern() ==b);
    }

    private static void testFinalString(){
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println(c);
        System.out.println((a == c));
        System.out.println((a == e));
    }

    private static void testConstantAndNewString() {
        String a = "hello";
        String b = "hello";
        String c = "hell" + "o";
        String d = new String("hello");

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == d );
    }
}
