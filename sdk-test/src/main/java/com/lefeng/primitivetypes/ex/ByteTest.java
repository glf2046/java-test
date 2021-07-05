package com.lefeng.primitivetypes.ex;

public class ByteTest {
    public static void main(String[] args) {
        byte b1 = -3;
        System.out.println(Integer.toBinaryString(b1));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString((int)(-3+Math.pow(2, 32))));
        System.out.printf("%.50f", Math.pow(2, 32));
        System.out.println();
        System.out.println("###### positive and negative byte number");
        byte b2 = 3;
        int b3 = b2;
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(Integer.toBinaryString(b3));
        System.out.println(Integer.toBinaryString(b2));
        System.out.println(Integer.toBinaryString(3));
    }
}
