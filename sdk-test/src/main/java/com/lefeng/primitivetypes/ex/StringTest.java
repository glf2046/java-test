package com.lefeng.primitivetypes.ex;

import java.util.Arrays;

public class StringTest {

    public static void main(String[] args) {
        testIntern();
    }

    static void testIntern(){
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());
    }
    static void testStringSplit(){
        String str = "boo:and:foo";
        //here the [o:] is a regular expression
        String[] array = str.split("[o:]");
        for(String s : array){
            System.out.println("\"" + s + "\"");
        }
        System.out.println("######################");
        System.out.println(Arrays.toString(array));
        String[] array1 = str.split(":");
        System.out.println(Arrays.toString(array1));
    }

    //String pool
    static void testReferenceEquality(){
        String str1 = new String("Hello");
        String str11 = new String("Hello");
        String str2 = "Hello";
        String str3 = "Hello";
        String str4 = "Hello";

        System.out.println(str1 == str11);
        System.out.println(str1.equals(str11));

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        System.out.println(str3 == str2);
        System.out.println(str3.equals(str2));

        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));
    }

    static boolean isPalindrome(String inputString){
        if(null == inputString){
         System.out.println("input string can't be null");
        }

        int len = inputString.length();

        if(len <=1){
            return true;
        }

        String inputStringInUpperCase = inputString.toUpperCase();

        int counter = len/2;

        for(int i = 0; i < counter; i++){
            if(inputStringInUpperCase.charAt(i) != inputStringInUpperCase.charAt(len - i-1)){
                return false;
            }
        }

        return true;
    }
}
