package com.lefeng.morgan.exceptiontest;

public class Target {

    public float divide(int a, int b) throws DividedByZeroException {
        if(b==0){
            throw new DividedByZeroException("zero input");
        }else {
            return a / b;
        }
    }
}
