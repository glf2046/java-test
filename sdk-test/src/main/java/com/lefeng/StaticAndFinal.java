package com.lefeng;

public class StaticAndFinal {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(new MyClass().j);
            System.out.println(new MyClass().i);
        }


    }
}

class MyClass {
    public final double i = Math.random();
    public static double j = Math.random();
}
