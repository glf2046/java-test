package com.lefeng.syntax_general;

import java.util.HashMap;

/**
 * @author guff
 * @since 2020-04-30 19:30
 */
public class AliTest {
    public static void main(String[] args) {
        float a = 0.125f;
        double b = 0.125d;
        System.out.println((a - b) == 0.0);

        a = 0.1f;
        b = 0.1d;
        System.out.println((a - b) == 0.0);

        double c = 0.8;
        double d = 0.7;
        double e = 0.6;
        double s1 = c - d;
        double s2 = d - e;
        System.out.println(s1 - s2 == 0);

        System.out.println(1.0 / 0);

        // compilation error
//        System.out.println(f1(null));

        HashMap hashMap = new HashMap(10000);
        for (int i = 0; i < 1000; i++) {
            hashMap.put(i, i);
        }

        g1(1);

        get("a", 1);
        String s3 = null;

        switch (s3) {
            case "a":
                System.out.println("hello");
            default:
                System.out.println("default");

        }



    }

    static <String, T, Alibaba> String get(String string, T t) {
        System.out.println(string);
        System.out.println(t);
        return string;
    }

    private static void g1(Integer integer) {
        System.out.println(integer);
    }

    private static void g1(double d) {
        System.out.println(d);
    }

    private static void f1(String s) {
        System.out.println(s);
    }

    private static void f1(Integer s) {
        System.out.println(s);
    }
}
