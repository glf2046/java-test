package com.lefeng.exception;

public class ExpBasic {
    public static void main(String[] args) {
        throwRunTimeExp();
    }

    private static void throwRunTimeExp(){
        System.out.println("throw runtime exp");
        throw new IllegalArgumentException("arg bad");
    }
}
