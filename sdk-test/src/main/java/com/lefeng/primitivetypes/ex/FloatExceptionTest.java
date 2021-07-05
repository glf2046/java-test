package com.lefeng.primitivetypes.ex;

public class FloatExceptionTest {
    public static void main(String[] args) {
        float f1 = 2.0f / 0.0f;
        System.out.println(f1);


        System.out.println("################## Invalid operation exception");

        double d1 = Math.sqrt(-1);
        System.out.println(d1);

    }
}
