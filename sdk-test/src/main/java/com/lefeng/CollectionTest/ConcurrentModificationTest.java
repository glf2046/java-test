package com.lefeng.CollectionTest;

import java.util.*;

public class ConcurrentModificationTest {
    public static void main(String[] args) {
        testHashtable();
    }

    private static void testHashtable() {
        Hashtable table = new Hashtable();
        for (int i = 0; i < 10; i++) {
            table.put(i, i);
        }

        //only remove five times, since size will keep reducing during removal
        //but there is no concurrent modification exception.
        for (int i = 0; i < table.size(); i++) {
            System.out.println("size: " + table.size());
            table.remove(i);
        }

        //There will be concurrent modification exception.
        Set set = table.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            table.remove(((Map.Entry)iterator.next()).getKey());
        }

        System.out.println("#####################");
        for(Object entry : table.entrySet()){
            System.out.println(((Map.Entry)entry).getKey() + ", " + ((Map.Entry)entry).getValue());
        }
    }

    private static void testArrayList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        //for 'forEach' is part of the 'iterable' interface which will get the initial modCount first
        //and compare the initial modCount with each new modCount after action performed
        //so the action in the 'forEach' part is not supposed to modify the elements,
        //otherwise there will be concurrent modification exception.
        //Can refer to the source code of 'forEach' in ArrayList.
        list.forEach((v) -> {
            list.remove(v);
        });

        //It won't cause any concurrent modification exception
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }

        //Here it's a 'foreach' statement, it will cause the concurrent modification exception
        //as compiler will essentially turn it to iterator.
        for(String item : list){
            list.remove(item);
        }

        //If we call 'iterator.remove()' then it's fine, however

        //Here if you use 'iterator.remove()' it's fine.
        //but if you use list.remove(item), then there will be concurrent modification exception
        //since during an iteration, you can only use iterator.remove to remove element, any other way will cause the exception aforementioned.
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            list.remove(item);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
