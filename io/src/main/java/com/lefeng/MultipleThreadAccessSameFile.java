package com.lefeng;

import java.io.*;
import java.net.URISyntaxException;

public class MultipleThreadAccessSameFile {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(()->{
                try {
                    FileOutputStream stream = new FileOutputStream(new File(MultipleThreadAccessSameFile.class.getResource("/write.txt").toURI()));
                    stream.write(("hello " + finalI).getBytes());
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    BufferedInputStream stream = new BufferedInputStream(MultipleThreadAccessSameFile.class.getResourceAsStream("/write.txt"));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                    System.out.println(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
