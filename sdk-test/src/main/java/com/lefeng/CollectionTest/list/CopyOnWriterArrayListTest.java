package com.lefeng.CollectionTest.list;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriterArrayListTest {
    public static void main(String[] args) {
        testTraverseWhileDeleteFromOtherThread();
    }

    private static void testBase() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        for (int i = 0; i < 10; i++) {
            list.remove(i);
        }

//        for (String item : list) {
//            list.remove(item);
//        }

        System.out.println("final size: " + list.size());
    }

    private static void testTraverseWhileDeleteFromOtherThread() {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(String.valueOf(i));
        }

        new Thread(() -> {
            System.out.println("#################");
            for (String item : arrayList) {
                System.out.println(item);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("#################");
            for (String item : arrayList) {
                System.out.println(item);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 9; i >= 0; i--) {
                arrayList.remove(i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
