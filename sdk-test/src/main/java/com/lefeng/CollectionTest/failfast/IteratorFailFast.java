package com.lefeng.CollectionTest.failfast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorFailFast {

    public static void main(String[] args) {
        testListIteratorModify();
    }

    private static void testListIteratorModify(){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            iterator.next();
            iterator.remove();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(list.size());
    }

    private static void testListIterator(){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        Thread t = new Thread(() -> {
            for (int i = 0; i < list.size(); i++) {
                list.remove(String.valueOf(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(list.size());
    }

    private static void testIterator(){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        Thread t = new Thread(() -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, "new value");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        for(String item : list){
            System.out.println(item);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(list.size());
    }
}
