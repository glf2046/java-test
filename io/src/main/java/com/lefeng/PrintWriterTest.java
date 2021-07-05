package com.lefeng;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author guff
 * @since 2020-04-13 00:24
 */
public class PrintWriterTest {
    public static void main(String[] args) {
        try {
            File file = new File( "fileWrite2.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw, true);


            pw.println("howdy");

            //If auto flush is enabled in the constructor, then every printf, pintln, format will flush buffer to output.
            Thread.sleep(5000);
            pw.println("folks");
//            pw.flush();
//            pw.close();


        } catch(IOException | InterruptedException ignored) { }
    }
}
