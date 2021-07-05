package com.lefeng.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 * @author guff
 * @since 2020-03-09 00:10
 */
public class PhantomReferenceTest {

    private static boolean isRun = true;

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException {
        String abc = new String("abc");
        System.out.println(abc.getClass() + "@" + abc.hashCode());
        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        new Thread(() -> {
            while (isRun) {
                Object obj = referenceQueue.poll();
                if (obj != null) {
                    try {
                        Field rereferent = Reference.class
                                .getDeclaredField("referent");
                        rereferent.setAccessible(true);
                        Object result = rereferent.get(obj);
                        System.out.println("gc will collect："
                                + result.getClass() + "@"
                                + result.hashCode() + "\t"
                                + (String) result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc,
                referenceQueue);
        abc = null;
        Thread.sleep(3000);
        System.gc();
        Thread.currentThread().sleep(3000);
        isRun = false;
    }
}
