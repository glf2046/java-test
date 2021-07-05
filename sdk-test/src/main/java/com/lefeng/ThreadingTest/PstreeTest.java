package com.lefeng.ThreadingTest;

import java.util.HashMap;
import java.util.Map;

public class PstreeTest {
    public static void main(String[] args) {

        System.out.println("a.b.c".replace("\\.", "/"));

        System.out.println("a.b.c".replace("\\.", "/"));

        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.forEach();

        System.out.println("\\.");
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
