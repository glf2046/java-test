package com.lefeng.primitivetypes;

public class DoubleComparison {
    public static void main(String[] args) {
        Long t1 = 123L;
        long t2 = 123;

        if (t2 == t1) {//不必拆箱
            System.out.println("t2 == t1");
        }

        if (t1 == t2) {
            System.out.println("t1 == t2");
        }

        Long t3 = 0L;
        if (t3 == 0L) {
            System.out.println("t3 == 0L");
        }

        Double d1 = 0.0;
        double d2 = 0.0;
        if (d1 == d2) {
            System.out.println("d1 == d2");
        }

        if (d2 == d1) {
            System.out.println("d2 == d1");
        }

        Double d3 = 0.0;
        double d4 = 0.000000;
        if (d3 == d4) {
            System.out.println("d3 == d4");
        }

        if (d4 == d3) {
            System.out.println("d4 == d3");
        }

        Double d5 = 0.0;
        double d6 = 0.0000000009;
        if (d5 == d6) {
            System.out.println("d5 == d6");
        }
        if (d6 == d5) {
            System.out.println("d6 == d5");
        }

        if (d5 == 0.0) {
            System.out.println("d5 == 0.0");
        }

        if (d5 != 0.0) {
            System.out.println("d5 != 0.0");
        }

        if (d5 == 0.00000) {
            System.out.println("d5 == 0.00000");
        }

    }
}
