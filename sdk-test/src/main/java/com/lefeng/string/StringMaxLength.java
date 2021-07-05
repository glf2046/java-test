package com.lefeng.string;

/**
 * @author guff
 * @since 2020-05-21 18:39
 */
public class StringMaxLength {

    static String a = "123";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        String a = "123";
//        for (int i = 0; i < 100000; i++) {
//            a += String.valueOf(i);
//        }

        A a = new A("", 0, "");

        for (int i = 0; i < 100000; i++) {
//            a = new A(String.valueOf(i), i, String.valueOf(i));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    static class A{
        private String s1;
        private Integer i1;
        private String s2;

        public A(String s1, Integer i1, String s2) {
            this.s1 = s1;
            this.i1 = i1;
            this.s2 = s2;
        }
    }
}
