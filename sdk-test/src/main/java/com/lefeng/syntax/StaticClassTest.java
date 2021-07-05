package com.lefeng.syntax;

public class StaticClassTest {

    private static final int a = 10;
    protected String s = "hello";

    private void f1(){

    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    static class B{
        private static void m1(){
        }

        private void m2(){
        }
    }
}
