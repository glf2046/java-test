package com.lefeng.morgan.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {
    public static void main(String[] args) {
        //It uses SynchronousQueue, so it does not cache any task, if just transfers to consumer.
        //Thus any new task will bring a new thread to be created if no free thread available at that moment.
        //The maximum of threads is Integer.MAX_VALUE.
        ExecutorService service = Executors.newCachedThreadPool();

    }
}
