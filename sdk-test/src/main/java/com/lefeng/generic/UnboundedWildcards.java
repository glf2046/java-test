package com.lefeng.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2);

        //List<Integer> is not subclass of List<Object>, so below call failed to compile.
        //printList(list);

        printListUnbounded(list);
    }

    public static void printList(List<Object> list) {
        List<Object> objects = new ArrayList<>();
        for (Object elem : list)    {
            System.out.println(elem + " ");
            objects.add(elem);
        }
        System.out.println();
    }

    public static void printListUnbounded(List<?> list) {
        List<?> objects = new ArrayList<>();
        //objects.add(new Object());
        //objects.add(null);

        for (Object elem: list){
            objects.add(null);
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
