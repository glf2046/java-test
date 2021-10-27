package com.lefeng.generic;

import java.util.ArrayList;
import java.util.List;

public class FinePrint2 {
    public static void main(String[] args) {
        // Not really allowed.
//        List<String>[] lsa = new ArrayList<String>[10];
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//// Unsound, but passes run time store check
//        oa[1] = li;

        // OK, array of unbounded wildcard type.
        List<?>[] lsa = new List<?>[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
// Correct.
        oa[1] = li;
// Run time error, but cast is explicit.
        String s = (String) lsa[1].get(0);
    }
}
