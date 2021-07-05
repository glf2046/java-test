package com.lefeng.string;

public class StringTest {

    //https://www.baeldung.com/java-string-pool
    public static void main(String[] args) {
        final String a = "hello";
        final String b = "hello";
        final String c = new String(b);
        final String d = new String(b);

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}
