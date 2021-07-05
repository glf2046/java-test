package com.lefeng.lock.biaslock;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BiasLockTest {

    private static List<Integer> strings = new Vector<>();

    //If you run the program with jvm args: -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
    //if will be faster since vector is "synchronized", using biased lock will speed up the processing of 'add'.
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
//        strings.hashCode();

        for (int i = 0; i < 10000000; i++) {
            strings.add(i);
        }


        stopWatch.stop();

        System.out.println(stopWatch.getTime());

        Thread.sleep(100000);
    }
}
