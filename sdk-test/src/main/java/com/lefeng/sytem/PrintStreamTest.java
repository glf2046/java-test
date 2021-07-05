package com.lefeng.sytem;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class PrintStreamTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        PrintStream printStream = new PrintStream(System.out, true, Charset.defaultCharset().toString());
        printStream.append("a");
//        printStream.print(0x61);
    }
}
