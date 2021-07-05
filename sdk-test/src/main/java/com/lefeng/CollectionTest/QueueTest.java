package com.lefeng.CollectionTest;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueTest {
    public static void main(String[] args) {
        testBasic();
    }

    private static void testBasic() {
        Queue<Integer> queue = new LinkedBlockingDeque<Integer>(20);
        System.out.println(queue.size());

        for(int i  = 0; i < 20; i++){
            queue.add(i);
        }

        for(int i = 10; i < 20; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
        
        System.err.println("some unknown fatal error");
    }
}