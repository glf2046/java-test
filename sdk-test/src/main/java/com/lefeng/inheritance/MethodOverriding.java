package com.lefeng.inheritance;

import java.io.IOException;

public class MethodOverriding {
    public static void main(String[] args) {
        A a = new B();
        try {
            a.m1();
        } catch (Exception e) {
            for(StackTraceElement s : e.getStackTrace()){
                System.out.println( s.getFileName() +  " | " + s.getClassName() + " | " + s.getMethodName() + " | (" + s.getLineNumber() + ")");

            }
        }
    }
}

class A{
    void m1() throws IOException {
        System.out.println("m1 in A called");
    }

    void m1(int a, String b){}

    void m1(String a, int b){}
}

class B extends A {
    @Override
    void m1() throws IOException, NumberFormatException{
        System.out.println("m1 in B called");
        throw new IOException("io exception here");
    }
}
