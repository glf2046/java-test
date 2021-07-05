package com.lefeng.morgan.collectiontest;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        //queue.add("a");
        //System.out.println(queue.size());

        SynchronousQueue<Integer> sc = new SynchronousQueue<>(); // 默认不指定的话是false，不公平的

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sc.take();
                    System.out.println("take done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        Thread.sleep(200);

        // sc.put(2);//没有线程等待获取元素的话，阻塞在此处等待一直有线程获取元素时候放到队列继续向下运行
        boolean result = sc.offer(2);// 没有线程等待获取元素的话，不阻塞在此处，如果该元素已添加到此队列，则返回 true；否则返回 false
        System.out.println(result);

        Thread.sleep(1000);
        t.interrupt();
    }
}
