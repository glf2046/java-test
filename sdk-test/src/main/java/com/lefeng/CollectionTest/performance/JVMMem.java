package com.lefeng.CollectionTest.performance;

import java.util.ArrayList;
import java.util.List;

public class JVMMem {

    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());                       

        System.gc();

        //Initial: 200M, 200M, 1000G

        //400M, left 200M is not enough, so directly apply for new 400M
        //so now total is 600M, left is still 200M, max is always 1000M, so max-to-apply is 1000M - 600M = 400M
        String[] s1 = new String[100000000];
        list.add(s1);
        System.out.println("added s1");
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());

        System.gc();

        //need another 400M, left 200M is not enough, so directly apply for new 400M
        //since total left is 400M from above, so it will first GC, apparently GC won't work in this case,
        //so it will OOM.
        //String[] s2 = new String[100000000];

        //200M
        //need another 200M, left 200M is not enough, so directly apply for new 200M
        //since total left is 400M, so applied success, now left is still 200M, total memory is 800M and total left is 1000M - 800M = 200M
        String[] s2 = new String[50000000];
        list.add(s2);
        System.out.println("added s2");
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());

        System.gc();


        //100M
        //need another 100M, although left 200M is enough but jvm won't use up all left memory, so it will try to GC probably,
        //so total left is still 200M and total memory is still 800M, left shrinks to 100M
        String[] s3 = new String[25000000];
        list.add(s3);
        System.out.println("added s3");
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());

        System.gc();

        //40M
        //need another 40M, left 100M is enough, so total left is still 200M and total memory is still 800M, left shrinks to 60M
        String[] s4 = new String[10000000];
        list.add(s4);
        System.out.println("added s4");
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());

        System.gc();

        //print out jvm args
        Thread.sleep(20000);
    }
}
