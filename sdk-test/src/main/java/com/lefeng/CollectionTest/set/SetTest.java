package com.lefeng.CollectionTest.set;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        testListWithDuplicatedElementsToSet();
        System.out.println("###############");
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");

        System.out.println(set);

        //set.forEach(System.out::println);

        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("a");
        System.out.println(collection);

        //collection.forEach(System.out::println);

        System.out.println("#####################");

        //to make collection unique
        Set<String> set2 = new HashSet<>(collection);
        //set2.forEach(System.out::println);
        //set2.addAll(new ArrayList<>());
        set2.remove("a");
        System.out.println(set2.size());
    }

    private static void testListWithDuplicatedElementsToSet(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("a");
        }

        Set<String> set = new HashSet<>(list);

        Iterator<String> iterator = set.iterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next());
       }
    }
}
