package com.lefeng.threading;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ControlThreadsNumberInATimeWindow {

    public static void main(String[] args) {
        new ControlThreadsNumberInATimeWindow().start();
    }

    public void start(){
        Client client = new Client();
        while(true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    client.callClient();
                }
            }).start();
        }
    }

    class Client{

        Semaphore semaphore = new Semaphore(10);

        public String callClient(){
            String result = null;
            try {
                semaphore.acquire();
                System.out.println(semaphore.availablePermits());
                result = getClientState();
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return result;
        }

        public String getClientState(){
            return String.valueOf(new SimpleDateFormat("yyyyMMddhhmmss|sss").format(new Date()));
        }
    }

    class Server{

        final Client client = new Client();
        volatile AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(10);
        List<String> result = new ArrayList<>();
        final int MAXTHREADS = 10;
        final int INTERVAL = 1;

        public void start(){
            while(true){
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       String response = client.getClientState();
                       result.add(response);
                       System.out.println(response);
                   }
               }).start();
            }
        }
    }
}
