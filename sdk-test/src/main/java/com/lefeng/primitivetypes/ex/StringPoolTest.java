package com.lefeng.primitivetypes.ex;

public class StringPoolTest {
    public static void main(String[] args) {
        //final string will be put into constant pool, reference to this string afterward will refer to the same string, so they are the same.
        final String constStr = "constant string";
        String varStr = "variable string";
        String s2 = varStr + " is not pooled";

        System.out.println("constant string is pooled" == constStr + " is pooled");
        System.out.println("variable string is not pooled" == s2);

        //this is how to use intern to return the new reference from constant pool
        s2 = s2.intern();
        System.out.println(s2 == "variable string is not pooled");
    }

    //String pool
    static void testReferenceEquality(){
        String str1 = new String("Hello");
        String str2 = "Hello";
        String str3 = "Hello";
        String str4 = "Hello";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        System.out.println(str3 == str2);
        System.out.println(str3.equals(str2));

        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));
    }
}
