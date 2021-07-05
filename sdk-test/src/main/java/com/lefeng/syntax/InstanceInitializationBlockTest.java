package com.lefeng.syntax;

public class InstanceInitializationBlockTest {

    private int num;

    // An instance initializer
    {
        this.num = 101;
        /* Other code for the instance initializer goes here */
    }

    {
        this.num = 102;
        /* Other code for the instance initializer goes here */
    }

    public static void main(String[] args) {
        InstanceInitializationBlockTest t1 = new InstanceInitializationBlockTest();
        System.out.println(t1.num);
    }
}
