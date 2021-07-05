package com.lefeng.others;

import java.util.*;

public class TestIntellijIntellisense {

    public static void test1(){
        System.out.println("HELLO");
        System.out.println("HELLO");
        System.out.println("HELLO");
        System.out.println("HELLO");
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);

        }



        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            System.out.println(next);
        }

        String[] test = {""};
        for (int i = 0; i < test.length; i++) {
            String s = test[i];
            System.out.println(s);
        }

        for (String s : test) {
            System.out.println(s);
        }


        for (StringTokenizer stringTokenizer = new StringTokenizer("a b c"); stringTokenizer.hasMoreTokens(); ) {
            String s = stringTokenizer.nextToken();
            System.out.println(s);
        }

        Vector<String> vector = new Stack<>();
        for (int i = 0; i < vector.size(); i++) {
            Object elementAt = vector.elementAt(i);

        }
    }
}
