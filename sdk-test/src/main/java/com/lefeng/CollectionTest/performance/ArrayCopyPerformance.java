package com.lefeng.CollectionTest.performance;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class ArrayCopyPerformance {

    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        testArrayCopy();
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }

    private static void testArrayCopy() throws InterruptedException {
        Integer[] arrayList = new Integer[200000];

        for (int i = 0; i < 200000; i++) {
            arrayList[i] = i;
        }

        Integer[] dest = new Integer[100000];

        for (int i = 0; i < 10; i++) {
            Integer[] temp = new Integer[100000000];
            list.add(temp);
            System.arraycopy(arrayList, 0, dest, 0, 100000);
            System.out.println(Runtime.getRuntime().freeMemory());
            Thread.sleep(1000);
        }

        System.out.println(dest.length);
        System.out.println(dest[99999]);
    }
}
