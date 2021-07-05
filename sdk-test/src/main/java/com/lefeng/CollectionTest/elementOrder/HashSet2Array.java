package com.lefeng.CollectionTest.elementOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class HashSet2Array {
    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        for (String item : list){
            System.out.println(item);
        }

        System.out.println("#######");

        HashSet<String> set2 = new HashSet<>(list);

//        for (String item : set2) {
//            System.out.println(item);
//        }

        ArrayList<String> list2 = new ArrayList<>(set2);
        System.out.println(list2.get(0));
        for (String item : list2) {
            System.out.println(item);
        }


//
//        HashSet<String> set = new HashSet<>(20);
//        for (int i = 0; i < 100; i++) {
//            set.add(String.valueOf(i));
//        }
//
////        for (String item : set){
////            System.out.println(item);
////        }
//
//        ArrayList<String> list = new ArrayList<>(set);
//
////        for(String item : list){
////            System.out.println(item);
////        }
//
//        System.out.println(list.get(0));
    }
}
