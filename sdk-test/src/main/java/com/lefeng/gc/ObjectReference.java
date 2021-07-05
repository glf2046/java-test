package com.lefeng.gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectReference {
    public static void main(String[] args) {
        final int Mega = 1024*1024;
        System.out.println(Runtime.getRuntime().freeMemory()/Mega);
        System.out.println(Runtime.getRuntime().maxMemory()/Mega);
        System.out.println(Runtime.getRuntime().totalMemory()/Mega);

        Map<Object, Object> map = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            byte[] bytes = new byte[1024*1024];
            map.put(i, bytes);
        }

        boolean run = true;

        map = null;

        System.gc();

        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Object());
        }

        System.gc();

        list = null;


        System.gc();

        System.out.println(Runtime.getRuntime().freeMemory()/Mega);
        System.out.println(Runtime.getRuntime().maxMemory()/Mega);
        System.out.println(Runtime.getRuntime().totalMemory()/Mega);

    }
}
