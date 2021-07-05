package com.lefeng.StringTest;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
    public static void main(String[] args) {

        String inputString = "789hello123world234";
        findNumberFromString(inputString);

        String a = "Java is great";
        String b = a.substring(5);
        System.out.println(b);

        StringTokenizer stringTokenizer = new StringTokenizer("hello world i'm here");
        while(stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
        StringTokenizer stringTokenizer1 = new StringTokenizer("hello world|of|java", " |");
        while(stringTokenizer1.hasMoreTokens()){
            System.out.println(stringTokenizer1.nextToken());
        }
    }


    private static void findNumberFromString(String inputString){
        Matcher toke = Pattern.compile("\\d+").matcher(inputString);
        while(toke.find()){
            System.out.println(toke.group(0));
        }
    }
}
