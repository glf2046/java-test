package com.lefeng.generic;

import java.util.ArrayList;
import java.util.List;

public class WildcardsAndSubtyping {
    public static void main(String[] args) {
        //List<Number> is subtype of List<? extends Number>
        List<Number> list1 =new ArrayList<>();
        List<? extends Number> list2  = list1;

        List<Number> list3 = new ArrayList<>();
        //list3 = list2;

        List<?> list4 = list1;
        List<?> list5 = list2;

        //strange?
        List<? super Integer> list6 = new ArrayList<>();
        List<? super Number> list7 = new ArrayList<>();
        list6 =list7;
        list4 = list6;
        list7 = list1;
    }
}
