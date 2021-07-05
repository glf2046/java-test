package com.lefeng.CollectionTest.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class KeySetTest {
    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(String.valueOf(i), i);
        }


        map.size();

        Set<String> keySet = map.keySet();

        Iterator<String> iterator = keySet.iterator();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                map.remove(String.valueOf(i));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        while (true) {
            for (String item : keySet) {
                System.out.println(item);
                Thread.sleep(1);
            }
        }

        //add operation is not allowed, since KeySet does not implement add, default will throw "UnsupportedException"
//        keySet.add("5");
//        keySet.add("6");


    }
}
