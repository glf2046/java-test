package com.lefeng.env;

import java.util.StringTokenizer;

public class StringToken {
    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("a||b|c");
        while(tokenizer.hasMoreElements()){
            System.out.println(tokenizer.nextToken("|"));
        }

        System.out.println("###################");
        String s1 = "hello";
        System.out.println(s1.indexOf('l', 4));
        System.out.println(s1.substring(3));
    }
}
