package com.lefeng.string;

/**
 * @author guff
 * @since 2020-05-23 14:57
 */
public class StringComparisonTest {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = "hello";

        System.out.println(s1 == s3);
        System.out.println(s1.equalsIgnoreCase(s3));

        System.out.println(s2 == s3);
        System.out.println(s2.equalsIgnoreCase(s3));
    }
}
