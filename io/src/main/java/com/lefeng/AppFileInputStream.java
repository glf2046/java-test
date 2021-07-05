package com.lefeng;

import java.io.*;

public class AppFileInputStream {
    public static void main(String[] args) throws IOException, InterruptedException {
       test1();

        System.out.println("exit test method");
       Thread.sleep(10000);
    }

    private static void test1() throws InterruptedException, IOException {

        Thread.sleep(10000);
        System.out.println("fileinputstream");

        //FileInputStream
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/guff/Documents/data/data.sql"));
//        FileInputStream fileInputStream = new FileInputStream(new File("io/src/main/resources/fileinputstream.txt"));

        Thread.sleep(5000);
        System.out.println("BufferedInputStream");

        BufferedInputStream bis = new BufferedInputStream(fileInputStream);

//        int c;
//
//        while((c = bis.read()) != -1){
//            System.out.println((char)c);
//        }
//
        System.out.println(bis.available());

        Thread.sleep(5000);
        System.out.println("new bytes");


        byte[] bytes = new byte[bis.available()];

        Thread.sleep(5000);
        System.out.println("read bytes");


        System.out.println(new String(bytes));

        Thread.sleep(5000);
    }
}
