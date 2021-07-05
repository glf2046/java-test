package com.lefeng;

import java.io.*;
import java.net.URISyntaxException;

public class MultileThreadAppendToFile {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {

        String s ="";
        for (int i = 0; i < 100000; i++) {
            s += "heo-";
        }

        for (int i = 0; i < 200; i++) {
            final int finalI = i;
            final String finalS = s;
            new Thread(()->{
                try {
                    FileWriter fw = new FileWriter(new File(MultileThreadAppendToFile.class.getResource("/write.txt").toURI()).getAbsoluteFile(),true);
                    fw.append((finalS + finalI));
                    fw.write(System.lineSeparator());
                    System.out.println(finalI + " append done");
                    fw.flush();
                    fw.close();
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
