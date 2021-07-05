package com.lefeng.CollectionTest.performance;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Collections;
import java.util.LinkedList;

public class LinkListCRUD {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        testSearch();
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }

    private static void testAdd() {
        LinkedList<Integer> a1 = new LinkedList<>();
        for (int i = 0; i < 2000000; i++) {
            a1.add(i);
        }
    }

    private static void testRemove() {
        LinkedList<Integer> a1 = new LinkedList<>();
        for (int i = 0; i < 2000000; i++) {
            a1.add(i);
        }

        for (int i = 0; i < 2000000; i++) {
            a1.remove(0);
        }

        System.out.println(a1.size());
    }

    private static void testUpdate() {
        LinkedList<Integer> a1 = new LinkedList<>();
        for (int i = 0; i < 2000; i++) {
            a1.add(i);
        }

        for (int i = 0; i < 2000; i++) {
            a1.set(i, i + 1);
        }

        System.out.println(a1.size());
        System.out.println(a1.get(0));
    }

    private static void testSearch() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 200000; i++) {
            list.add(i);
        }

        int index = Collections.binarySearch(list, 100000);
        System.out.println(index);
    }

    private static void testRandomAccess() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 20000; i++) {
            list.add(i);
        }

        int j = 0;

        for (int i = 0; i < 20000; i++) {
            j = list.get(i);
        }

        System.out.println(list.size());
        System.out.println("j: " + j);
    }
}
