package com.lefeng.lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Lamda_10 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        Thread.sleep(5000);

        //ForkJoinPool 多线程去处理
        List<String> collect = list.parallelStream().filter((i) -> {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i > 0;
        }).map(String::valueOf).collect(Collectors.toList());

        for (String s : collect) {
            System.out.println(s);
        }
    }
}
