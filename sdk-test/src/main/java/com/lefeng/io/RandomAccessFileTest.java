package com.lefeng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;

/**
 * @author guff
 * @since 2020-01-24 03:10
 */
//https://blog.csdn.net/Lirx_Tech/article/details/51234056
public class RandomAccessFileTest {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/guff/Dev/java-test/sdk-test/src/main/resources/file1.txt", "rws")) {

            System.out.println("Initial file pointer position: " + randomAccessFile.getFilePointer());
            System.out.println("Initial file descriptor: " + randomAccessFile.getFD());
            System.out.println("Initial file channel: " + randomAccessFile.getChannel());
            System.out.println("Initial file length: " + randomAccessFile.length());

            randomAccessFile.seek(3);

            randomAccessFile.skipBytes(1);

            for (int i = 0; i < 10; i++) {
                System.out.println("read string[" + i + "]: " + (char)randomAccessFile.readByte());
            }

            randomAccessFile.skipBytes(1);

            System.out.println("read string: " + randomAccessFile.readChar());

            randomAccessFile.seek(4);

            System.out.println("read string: " + randomAccessFile.readChar());

            System.out.println(randomAccessFile.getFilePointer());

            insertInTheMiddle(randomAccessFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendTest(RandomAccessFile file) throws IOException {
        file.seek(file.length());
        file.write("hello".getBytes());
    }

    /**
     * 中间插入内容
     * @param file
     */
    private static void insertInTheMiddle(RandomAccessFile file) throws IOException {
        File temp = File.createTempFile("temp", null);
        temp.deleteOnExit();
        FileOutputStream fileOutputStream = new FileOutputStream(temp);
        FileInputStream fileInputStream = new FileInputStream(temp);
        
        file.seek(5);
        byte[] bytes = new byte[10];

        while(file.read(bytes) > 0){
            fileOutputStream.write(bytes);
        }

        file.seek(5);

        file.write("world".getBytes());

        while(fileInputStream.read(bytes) > 0){
            file.write(bytes);
        }

    }

}
