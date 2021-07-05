package com.lefeng.StringTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        // °????¨??????×??????é??
        String line = "This order was placed for QT3000!!!";
        //1. need to escape te special char of '\' which combines with d to stand for numbers, i.e. 0-9

        //2. note here if you put a '?' at the end of the first group, then it's not greedy, so the first group only try to match
        //against the shortest string which matches the firs group's regex and in the meanwhile, it satisfies the second group as well.
        // , i.e. "This order was placed for QT", this way, the second group will match to "3000".
        //On the contrast, if we don't put a '?' at the end of the first group, then it's greedy, so the first group will match to
        //"This order was placed for QT300", note: it leaves the last digit to the second group.
        String pattern = "(.*?)(\\d+)(!*)";

        // ???¨ Pattern ???ó
        Pattern r = Pattern.compile(pattern);

        // ???????¨ matcher ???ó
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println(m.groupCount());
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    private static void findAllMatches(){
        String inputString = "789hello123world234";
        Matcher toke = Pattern.compile("\\d+").matcher(inputString);
        while(toke.find()){
            System.out.println(toke.group(0));
        }
        short a = 1;
    }
}
