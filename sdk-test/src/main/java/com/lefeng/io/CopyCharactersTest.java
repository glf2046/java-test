package com.lefeng.io;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CopyCharactersTest {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        OutputStreamWriter outputStream = null;

        try {
            inputStream = new FileReader("in.txt");
            outputStream = new OutputStreamWriter(new FileOutputStream("out.txt",true), "UTF-8");

            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char)c);
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}