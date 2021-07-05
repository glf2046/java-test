package com.lefeng.CollectionTest.failfast;

import java.util.*;

public class RemoveItemFromList {

    public static void main(String[] args) {
        testRemoveDuplicatedElements();
        System.out.println("##############");
        List<String> sourceList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sourceList.add(String.valueOf(i));
        }

        List<Integer> indexToRemove = new ArrayList<>();
        indexToRemove.add(4);
        indexToRemove.add(5);
        indexToRemove.add(2);
        indexToRemove.add(1);
        indexToRemove.add(3);

        removeIncludingDuplicates3(sourceList, indexToRemove);
        printList(sourceList);
//
//        remove(sourceList, listToRemove);
//
//        printList(sourceList);
    }

    private static void testRemoveDuplicatedElements(){
        List<String> sourceList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            sourceList.add("a");
        }

        sourceList.add("b");
        sourceList.add("c");

        for (int i = 0; i < 5; i++) {
            sourceList.add("d");
        }

        for (int i = 0; i < 5; i++) {
            sourceList.add("e");
        }

        List<String> listToRemove = new LinkedList<>();
        listToRemove.add("a");
        listToRemove.add("d");

        removeIncludingDuplicatedElements2(sourceList, listToRemove);
        printList(sourceList);
    }

    private  static void printList(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void remove(List<String> sourceList, List<String> listToRemove){
        for(String item : listToRemove){
            sourceList.remove(item);
        }
    }

    //Remove all the elements in 'listToRemove' from 'sourceList', including all the occurrences.
    //Using 'adjusted' index'
    private static void removeIncludingDuplicatedElements1(List<String> sourceList, List<String> listToRemove){
        for(String item : listToRemove){
            int size = sourceList.size();
            for(int i = 0; i < size; i++){
                if(sourceList.size() - i >= 1) {
                    String s = sourceList.get(i);
                    if (s.equals(item)) {
                        sourceList.remove(s);
                        i--;
                    }
                }
            }
        }
    }

    //Remove all the elements in 'listToRemove' from 'sourceList', including all the occurrences.
    //Using 'lastIndexOf'
    private static void removeIncludingDuplicatedElements2(List<String> sourceList, List<String> listToRemove){
        for(String item : listToRemove){
            int index = sourceList.lastIndexOf(item);
            while(index >=0 ){
                sourceList.remove(index);
                index = sourceList.lastIndexOf(item);
            }
        }
    }

    //Removing according to 'indexes'
    //Remove all the elements in 'indexToRemove' from 'sourceList', including all the occurrences.
    //Using 'lastIndexOf'
    private static void removeIncludingDuplicates2(List<String> sourceList, List<Integer> indexToRemove){


        //Sort the indexes and make it in a reverse order, bigger first, smaller last.
        //so remove from the later one, then removal action won't affect the former indexes.
        indexToRemove.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        Set<Integer> set = new HashSet<>(indexToRemove);

        for(int index : set){
           sourceList.remove(index);
        }
    }

    //Removing according to 'indexes'
    //First get all the corresponding elements from the given indexes
    //then remove the elements.
    private static void removeIncludingDuplicates3(List<String> sourceList, List<Integer> indexToRemove){

        //Remove duplicated indexes
        Set<Integer> indexSet = new HashSet<>(indexToRemove);
                
        List<String> itemsToRemove = new ArrayList<>();
        for(int index : indexSet){
            String item = sourceList.get(index);
            itemsToRemove.add(item);
        }

        for(String item : itemsToRemove){
            sourceList.remove(item);
        }
    }
}
