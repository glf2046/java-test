package com.lefeng;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author guff
 * @since 2020-05-14 03:18
 */
public class ConcurrentReadWriteFile {
    //https://www.geeksforgeeks.org/java-appending-string-file/
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        File file = new File("concurrency.txt");
        if (file.exists()) {
            file.delete();
        }
        final Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            new Thread(() -> {
                synchronized (lock) {
                    try {
                        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + " - CountDownLatch awaiting...");
//                        latch.await();
                        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + " - CountDownLatch entered...");

                        // Open given file in append mode.
                        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
                        out.write(String.valueOf(j));
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        Thread.sleep(1000);
//        latch.countDown();
    }
}
