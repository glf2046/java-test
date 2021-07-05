package com.lefeng.primitivetypes.ex.bitoperator;

public class BitTest {

    public static void main(String[] args) {
        testSwapUsingBit();
    }

    private static void testSwapUsingBit(){
        int a = 4;
        int b = 3;

        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println(a^b);
        System.out.println(a^b^b);
        System.out.println(a^b^a);
    }
}

