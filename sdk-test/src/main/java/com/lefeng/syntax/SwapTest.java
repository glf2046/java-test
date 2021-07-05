package com.lefeng.syntax;

public class SwapTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        a = a^b;
        b = a^b ;
        a = b^a ;
        //swapBit(a,b);
        System.out.println(a);
        System.out.println(b);

        String c ="c";
        String d ="d";
        swap(c ,d);
        System.out.println(c);
        System.out.println(d);
    }

    private static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    private static void swapBit(int a, int b){
        a = a^b ;
        b = a^b ;
        a = b^a ;
    }

    private static void swap(String a, String b){
        String temp = a;
        a = b;
        b = temp;
    }
}
