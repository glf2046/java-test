package com.lefeng.primitivetypes.ex;

public class EqualOperatorTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a.equals(b));

        float f1=10.222222222f, f2=10.2222222912345655555555f;
        System.out.println(f1==f2);


        double d1=10.222222222d, d2=10.2222222912345655555555d;
        System.out.println(d1==d2);
    }
}
