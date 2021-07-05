package com.lefeng.CollectionTest.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        testCommon();
    }
    private static void testCommon(){

        //ReentrantLock internally 
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.add("item1");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.element());
    }

}
