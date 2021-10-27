package com.lefeng;

import java.io.*;

public class FileTest {
    public static void main(String[] args) {


    }

    private void getFile(String fileName) {
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this.getClass().getResource(fileName));
        File file = new File(this.getClass().getResource(fileName).getFile());
        System.out.println(file.exists());
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileReader != null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String temp;
        try {
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
