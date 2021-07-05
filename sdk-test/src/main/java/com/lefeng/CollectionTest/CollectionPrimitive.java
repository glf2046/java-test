package com.lefeng.CollectionTest;

import java.util.ArrayList;
import java.util.List;

public class CollectionPrimitive {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(8);

        for(Object o : list){
            System.out.println(o);
        }

        char c = new Character('a');
        System.out.println(c);
    }
}
