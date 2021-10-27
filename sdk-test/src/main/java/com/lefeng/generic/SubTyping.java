package com.lefeng.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubTyping {
    public static void main(String[] args) {
        List<Object> ls = new ArrayList<>(); // 1
        ls.add("asdf");

        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<Object>();
        fromArrayToCollection(oa, co);
    }

    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o); // Correct
        }
    }
}
