package com.lefeng.exclusive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;

public class RandomAccess {
    public static void main(String[] args) throws URISyntaxException, IOException {
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(() -> {
                RandomAccessFile file = null;
                try {
                    Thread.sleep(3000);
                    file = new RandomAccessFile(new File(RandomAccess.class.getResource("/write.txt").toURI()), "rw");
                    file.write(("test " + finalI).getBytes());
                } catch (URISyntaxException | InterruptedException | IOException e) {
                    e.printStackTrace();
                }
                try {
                    assert file != null;
                    System.out.println(file.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
