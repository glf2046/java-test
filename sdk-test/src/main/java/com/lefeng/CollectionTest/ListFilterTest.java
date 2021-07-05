package com.lefeng.CollectionTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListFilterTest {
    public static void main(String[] args) {
        List<String> newList = new ArrayList<>();
        for(int i =0; i < 10; i++){
            newList.add(String.valueOf(i));
        }

        List<Integer> removal= new ArrayList<>();
        removal.add(0);
        removal.add(1);
        removal.add(2);

        filter2(newList, removal );
    }

    private static <E> void filter3(List<E> list, List<Integer> indiceToRemove){
        //Sort the 'indiceToRemove', and remove from the last one
        //then there is no index contention
    }

    private static <E> void filter2(List<E> list, List<Integer> indiceToRemove){
         List<E> resultList = list.stream().filter(k -> indiceToRemove.contains(k)).collect(Collectors.toList());

        for(int i = 0; i < resultList.size(); i++){
            System.out.println(resultList.get(i));
        }
    }

    private static <E> void filter(List<E> list, List<Integer> indiceToRemove){
        List<E> resultList = new ArrayList<>();
        for(int i =0; i < list.size(); i++){
            if(!indiceToRemove.contains(i)){
                resultList.add(list.get(i));
            }
        }

        for(int i = 0; i < resultList.size(); i++){
            System.out.println(resultList.get(i));
        }
    }
}
