package com.lefeng.syntax;

public class FinalTest {
    public static void main(String...args) throws CloneNotSupportedException {
        final int multiplier; // A blank final variable
         /* Do something here... */

         // Set the value of multiplier first time
        multiplier = 3;

        int[] array = {1,2};

        // Ok to read the multiplier variable
        int value = 100 * multiplier;
        System.out.println(value);

        FinalTest ft = new FinalTest();
        Object o = ft.clone();
        ft.getClass();
        System.out.println(o);
    }
}
