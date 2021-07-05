package com.lefeng.primitivetypes.ex;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ReferenceQueueTest {
    
    public static void main(String[] args) {
        final int OneM = 1024*1024;
        Object value = new Object();
        Map<Object, Object> map = new HashMap<>();
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();

        for (int i = 0; i < 1000; i++) {
            byte[] bytes = new byte[OneM];
            WeakReference<byte[]> weakReference = new WeakReference<>(bytes, referenceQueue);
            map.put(weakReference, value);
        }

        System.out.println("map size:" + map.size());

        Thread thread = new Thread(() -> {
            int cnt = 0;
            WeakReference k;
            try {
                while ((k = (WeakReference) referenceQueue.remove()) != null) {
                    System.out.println((cnt++) + " gc collected: " + k);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("map size:" + map.size());

    }
}
