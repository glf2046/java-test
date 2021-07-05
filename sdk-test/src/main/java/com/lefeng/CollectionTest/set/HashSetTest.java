package com.lefeng.CollectionTest.set;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest {

    final static int MAX_COUNT = 1000000;

    static Set<Integer> hashSet = new HashSet<>();
    static Set<Integer> treeSet = new TreeSet<>();
    static Set<Integer> linkedHashSet = new LinkedHashSet<>();

    {
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        linkedHashSet = new LinkedHashSet<>();
    }

    public static void main(String[] args) throws InterruptedException {
        System.gc();
        Runtime.getRuntime().runFinalization();
        System.gc();
        testAddDuplicates(new HashSet<>());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(2000);
        stopWatch.stop();
        stopWatch.split();
        System.out.println("first time: "  + stopWatch.getSplitTime());
        testAddPerformance();
        testRemovePerformance();
    }

    private static  void testAddDuplicates(HashSet<String> set){
        set.add("item1");
        set.add("item1");
        for(String item : set){
            System.out.println(item);
        }
    }

    private static void testRemovePerformance() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for(int i = 0; i < MAX_COUNT; i++){
            hashSet.remove(i);
        }

        stopWatch.stop();
        stopWatch.split();

        System.out.println(stopWatch.getSplitTime());
        stopWatch.reset();
        stopWatch.start();

        for(int i = 0; i < MAX_COUNT; i++){
            treeSet.remove(i);
        }
        stopWatch.stop();
        stopWatch.split();

        System.out.println(stopWatch.getSplitTime());
        stopWatch.reset();
        stopWatch.start();

        for(int i = 0; i < MAX_COUNT; i++){
            linkedHashSet.remove(i);
        }
        stopWatch.stop();
        stopWatch.split();

        System.out.println(stopWatch.getSplitTime());
    }

    private static void testAddPerformance() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for(int i = 0; i < MAX_COUNT; i++){
            hashSet.add(i);
        }

        stopWatch.stop();
        stopWatch.split();

        System.out.println(stopWatch.getSplitTime());
        stopWatch.reset();
        stopWatch.start();

        for(int i = 0; i < MAX_COUNT; i++){
            treeSet.add(i);
        }
        stopWatch.stop();
        stopWatch.split();

        System.out.println(stopWatch.getSplitTime());
        stopWatch.reset();
        stopWatch.start();

        for(int i = 0; i < MAX_COUNT; i++){
            linkedHashSet.add(i);
        }
        stopWatch.stop();
        stopWatch.split();
        System.out.println(stopWatch.getSplitTime());
    }
}
