package com.lefeng.primitivetypes.ex;

import java.util.ArrayList;

public class LeftRightValue {
    public static void main(String[] args) {
        testArrayCopy2();
        int i;
        String s;
        System.out.println(i=3);
        System.out.println(s = "hello");

        System.out.println(new String("s").hashCode());
        System.out.println(new String("s").hashCode());

        int a = 115;
        System.out.println(Integer.toBinaryString(115));
    }

    private static void testArrayCopy(){
        String[] s1 = new String[10];
        for (int i = 0; i < 10; i++) {
            s1[i] = String.valueOf(i);
        }

        String[] s2 = new String[10];

        System.arraycopy(s1, 0, s2, 0, s1.length);

        for (int i = 0; i < 10; i++) {
            System.out.println(s2[i]);
        }
    }

    private static void testArrayCopy2(){
        ArrayList<String> a1 = new ArrayList<>();
        for (int w = 0; w < 10; w++) {
            a1.add(String.valueOf(w));
        }

        ArrayList<String> a2 = new ArrayList<>();

        System.arraycopy(a1, 0, a2, 0, a1.size());

        for (int i = 0; i < 10; i++) {
            System.out.println(a2.get(i));
        }
    }
}
