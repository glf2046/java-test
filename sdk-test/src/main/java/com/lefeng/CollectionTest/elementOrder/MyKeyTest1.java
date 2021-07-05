package com.lefeng.CollectionTest.elementOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyKeyTest1 {
    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            List<MyKey> keys = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                keys.add(new MyKey(i, "a"));
            }

            HashMap<MyKey, String> map = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                map.put(keys.get(i), String.valueOf(i));
            }

            ArrayList<MyKey> keys2 = new ArrayList<>(map.keySet());

            System.out.println(keys2.get(0));
        }

        System.out.println("#########");
    }
}
