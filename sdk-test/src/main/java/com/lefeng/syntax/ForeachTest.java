package com.lefeng.syntax;

import java.util.ArrayList;
import java.util.List;

public class ForeachTest {
    public static void main(String[] args) {
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(4);
        integerArrayList.add(56);
        //Will cause "ConcurrentModificationException"
        //integerArrayList.remove(i);
        //integerArrayList.forEach(System.out::println);

        //integerArrayList.remove(54);
        //here the argument is an object, so it will take '4' as the element to remove from the array rather than the index of the element.
        integerArrayList.remove((Integer)4);
        System.out.println(integerArrayList);
    }
}
