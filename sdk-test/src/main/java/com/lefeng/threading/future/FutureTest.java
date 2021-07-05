package com.lefeng.threading.future;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        testCommon();
    }
    private static void testCommon(){
        FutureTask<String> task = new FutureTask<String>(new MyTask());
        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service1 = Executors.newFixedThreadPool(2);
        ExecutorService service2 = Executors.newCachedThreadPool();
        ExecutorService service3 = Executors.newSingleThreadScheduledExecutor();
        ExecutorService service4 = Executors.newScheduledThreadPool(2);
        service.submit(task);
        //service.execute();

        //Main thread turns to do something else and wait for the future task to return
        try {
            Thread.sleep(1000);
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class MyTask implements Callable<String>{

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() throws Exception {
            //Doing some time consuming calculation or network or IO operation.
            return  "task result: 123";
        }
    }
}
