package com.lefeng.others.isnum;

import java.util.regex.Pattern;

public class NumberChecker {

    public static void main(String[] args) throws InterruptedException {
        String s = "123456789";
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            isNumeric(s);
        }
        long end = System.nanoTime();
        System.out.println(end -start);
        System.out.println("###########");
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            isNumeric2(s);
        }
        end = System.nanoTime();
        System.out.println(end -start);

        //from the result, 'isNumeric' is much more quicker, a scale less than 'isNumeric2', since it just iterate through the string once.
        //'isNumeric2' somehow try to match which will cause it tries to match from different starting position.
    }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric2(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
