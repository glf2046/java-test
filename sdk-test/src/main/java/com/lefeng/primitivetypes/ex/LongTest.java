package com.lefeng.primitivetypes.ex;

public class LongTest {

    public static void main(String[] args) {
        testLongEquality();
    }

    //If using 'Long' it's an object but when it's <=127, it's the same instance, otherwise...
    //If using 'long' it's primitive type, so it's always equal when comparing using '=='
    private static void testLongEquality(){

        Long l1 = 128L;
        Long l2 = 128L;
        System.out.println(l1 == l2);

        Long l3 = 127L;
        Long l4 = 127L;
        System.out.println(l3 == l4);


        long l5 = 128L;
        long l6 = 128L;
        System.out.println(l5 == l6);

    }
}
