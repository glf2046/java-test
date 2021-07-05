package com.lefeng.primitivetypes;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Int {
    public static void main(String[] args) {

        System.out.println(new Integer(1).equals(1));
        System.out.println(new Integer(1024).equals(1024));

        Integer i1 = 1;
        Integer i2 = 1;

        System.out.println(i1 == i2);

        Integer i3 = new Integer(3);
        Integer i4 = new Integer(3);
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

        System.out.println("########");
        String s1 = "a";
        String s2 = new String("a");
        String s4 = s2.intern();
        String s3 = "a";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println(s4 == s3);
        System.out.println(s4.equals(s3));
        System.out.println(Integer.MAX_VALUE);
        int result = testMultiple(Integer.MAX_VALUE, Integer.MAX_VALUE);
        System.out.println(result);

        BigInteger result2 = testMultipleBig(Integer.MAX_VALUE, Integer.MAX_VALUE);
        System.out.println(result2);

        BigDecimal result3 = testMultipleDecimal(Integer.MAX_VALUE, Integer.MAX_VALUE);
        System.out.println(result3);

        double twoG = Math.pow(2, 30);
        System.out.println(twoG);

        System.out.println(Math.pow(2, 31) -1);

        System.out.println("############");
        System.out.println(testMultipleLongBigDecimal(Long.MAX_VALUE, Long.MAX_VALUE));

        System.out.println("############");
        System.out.println(testMultiple(Double.MAX_VALUE, Double.MAX_VALUE));

    }

    //overflow
    private static int testMultiple(int a, int b){
        return a*b;
    }

    private static BigInteger testMultipleBig(int a, int b){
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
    }

    //overflow
    private static BigDecimal testMultipleDecimal(int a, int b){
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }

    private static long testMultiple(long a, long b){
        return a*b;
    }

    private static BigDecimal testMultipleLongBigDecimal(long a, long b){
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }

    //might overflow
    private static double testMultiple(double a, double b){
        return a*b;
    }

    private static BigDecimal testMultipleDoubleBigDecimal(double a, double b){
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }

    //might overflow
    private static float testMultiple(float a, float b){
        return a*b;
    }

    private static BigDecimal testMultipleFloatBigDecimal(float a, float b){
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }
}
