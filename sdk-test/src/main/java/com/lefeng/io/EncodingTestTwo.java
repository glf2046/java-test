package com.lefeng.io;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class EncodingTestTwo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        final String a = "a";
        System.out.println(a);
        String charSet = Charset.defaultCharset().name();
        System.out.println(charSet);
        System.out.println(System.getProperty("file.encoding"));
        byte[] bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println(new String(bytes, charSet));

        charSet = "US-ASCII";
        bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println("US-ASCII:" + new String(bytes, charSet));

        charSet = "utf-8";
        bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println("UTF-8:" + new String(bytes, charSet));

        charSet = "utf-16";
        bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println("UTF-16:" + new String(bytes, charSet));

        charSet = "utf-32";
        bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println("UTF-32:" + new String(bytes, charSet));

        charSet = "ISO-8859-1";
        bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println(new String(bytes, charSet));

        charSet = "Big5";
        bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println(new String(bytes, charSet));

        charSet = "GB2312";
        bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println(new String(bytes, charSet));

        charSet = "GB18030";
        bytes = a.getBytes(charSet);
        printHexString(bytes);
        System.out.println(new String(bytes, charSet));
    }

    public static void printHexString(byte[] b)
    {
        for (byte aB : b) {
            String hex = Integer.toHexString(aB & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase() + " ");
        }
        System.out.println("");
    }
}

