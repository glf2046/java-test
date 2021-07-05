package com.lefeng.sytem;

public class SystemTest {
    public static void main(String[] args) {
        SystemTest test = new SystemTest();

        System.out.println(test.hashCode());
        System.out.println(System.identityHashCode(test));

        System.out.println(System.lineSeparator());
        System.out.println(System.lineSeparator().length());
    }
}
