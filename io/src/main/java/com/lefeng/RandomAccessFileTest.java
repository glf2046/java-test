package com.lefeng;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class RandomAccessFileTest {

    private static final String FILEPATH = "/Users/guff/Documents/data/data4.sql";
//    private static final String FILEPATH = "/Users/guff/Dev/java-test/io/src/main/resources/fileinputstream.txt";

    public static void main(String[] args) {

        try {

            System.out.println(Charset.defaultCharset());

            //new String(byte[] byte) will decode the input bytes using the system default encoding, i.e. UTF-8
            //so if you switch to use other encoding like ASCII, then you won't get the correct chinese chars
//            System.out.println(new String(readFromFile(FILEPATH, 49, 100), Charset.forName("ASCII")));
            System.out.println(new String(readFromFile(FILEPATH, 2884386500L, 100), Charset.forName("UTF-8")));

            //writeToFile(FILEPATH, "JavaCodeGeeks Rocks!", 22);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static byte[] readFromFile(String filePath, long position, int size)
            throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        System.out.println(file.length());
        file.seek(position);
        byte[] bytes = new byte[size];
        file.read(bytes);
        file.close();

        stopWatch.stop();
        System.out.println("read time: " + stopWatch.getTime());


        return bytes;

    }

    private static void writeToFile(String filePath, String data, int position)
            throws IOException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(position);
        file.write(data.getBytes());
        file.close();

        stopWatch.stop();
        System.out.println("write time: " + stopWatch.getTime());

    }
}
