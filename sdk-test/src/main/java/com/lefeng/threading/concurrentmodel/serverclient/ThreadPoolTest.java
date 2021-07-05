package com.lefeng.threading.concurrentmodel.serverclient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolTest server = new ThreadPoolTest();
        server.init();

        List<FutureTask> futureTasks = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            FutureTask futureTask = server.submit(new Request(i, "name" + String.valueOf(i)));
            if(i%10 == 0){
                futureTask.cancel(true);
            }
            futureTasks.add(futureTask);
            System.out.println("Submitted number " + i + " task");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking future task status");
        for (int i = 0; i < futureTasks.size(); i++) {
            FutureTask task = futureTasks.get(i);
            if(task.isCancelled()) {
                System.out.println("cancelled");
            }else if(task.isDone()){
                System.out.println(" is done");
            }else
                System.out.println("undone");
        }
    }
    
    private final int MAXPOOLSIZE = 5;
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(60);
    private List<Worker> pool = new ArrayList<>(MAXPOOLSIZE);

    public void init() {
        queue.clear();
    }

    private void addWorker(Runnable task) {
        Worker w = new Worker(task);
        Thread t = w.getThread();
        t.start();
        w.setRunning(true);
        //Once added to pool list, it won't be recycled until program exits.
        pool.add(w);
    }

    public <T> void execute(Request r) {
        execute(transformRequest(r));
    }

    public <T> FutureTask<T> submit(Request r) {
        FutureTask<T> task = transformRequestCallable(r);
        execute(task);
        return task;
    }

    public void execute(Runnable task){
        if (pool.size() < MAXPOOLSIZE) {
            addWorker(task);
        } else {
            try {
                queue.put(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Runnable transformRequest(Request r) {
        Runnable task = () -> {
            int id = r.getId();
            String message = r.getMessage();
            System.out.println("Response: " + id + ", " + message);
        };

        return task;
    }

    private FutureTask transformRequestCallable(Request r) {
        FutureTask task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() {
                int id = r.getId();
                String message = r.getMessage();
                System.out.println("Response: " + id + ", " + message);
                return "Response: " + id + ", " + message;
            }});

        return task;
    }

    class Worker implements Runnable {

        public void setTask(Runnable task) {
            this.task = task;
        }

        public Thread getThread() {
            return thread;
        }

        private Thread thread;
        private Runnable task;

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean running) {
            isRunning = running;
        }

        private boolean isRunning = false;

        public Worker(Runnable task) {
            this.thread = new Thread(this);
            this.task = task;
        }

        public void run() {
            try {
                while(task != null || (task = queue.take()) != null){
                    System.out.println("Current queue size: "  + queue.size());
                    System.out.println("Current workers size: "  + pool.size());
                    System.out.println("#############################################");
                    task.run();
                    task = null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
