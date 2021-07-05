package com.lefeng.morgan;

public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(a == b);

        final String c = "";
        String d = c + "a";
        System.out.println(a == d);
        System.out.println(a.equals(d));
    }
}
