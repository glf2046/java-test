package com.lefeng.CollectionTest.blockqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedDequeTest {
    //CAS mechanism ensures the high performance when there is not much actual racing.
    public static void main(String[] args) {
        testCommon();
    }

    private static void testCommon(){
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("item1");
        queue.offer("item2");
        System.out.println(queue.peek());
        String item = queue.poll();
        System.out.println(item);
        System.out.println(queue.size());
        System.out.println(queue.element());
    }
}
