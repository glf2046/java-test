package com.lefeng;

public class test1 {

    String paramString = "C1155B144C1F30A3B9C32BF9A0DE1359";
    static
    {
        System.loadLibrary("goodluck");
    }
    public native static int get();
    public native static void set(int i);

    public static void main(String[] args) {


        test1 test = new test1();
        test.set(10);
        System.out.println(test.get());


    }
}
