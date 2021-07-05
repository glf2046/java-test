package com.lefeng.unsafe;

public class UnsafeMain {
    public static void main(String[] args) {
        UnsafeParkTest test= new UnsafeParkTest();
        test.lockRes();
        test.unlockRes();
    }
}
