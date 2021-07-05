package com.lefeng.StringTest;

import java.util.Stack;

public class StingBuilderTest {
    public static void main(String[] args) {
        reverseStringUsingStack();
    }

    private static void testStringBufferBasic(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append('\u00a5');

        System.out.println(stringBuffer.toString());
    }

    private static void reverseString(){
        String a = "abcde";
        StringBuffer reverse = new StringBuffer(a).reverse();
        System.out.println(reverse.toString());
    }

    private static void reverseStringUsingStack(){

        String a = "abcde";
        String[] splitArray = a.split("");
        String joint = String.join(" ", splitArray);
        System.out.println(joint);
        Stack stack = new Stack();
        for(String s : splitArray){
            stack.push(s);
        }


        int index = stack.search("a");
        System.out.println(index);
        stack.addElement("f");
        stack.remove("f");
        stack.add("g");
        stack.removeElement("g");

        System.out.println(stack.capacity());
        System.out.println(stack.contains("a"));
        System.out.println("element at index of 2 is : " + stack.elementAt(2));
        System.out.println("the first element is : " + stack.firstElement());
        System.out.println("the element got at index 3 is : " + stack.get(3));

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + "-");
        }



//        int count = stack.size();
//        for(int i = 0; i < count; i++){
//            System.out.print(stack.pop() + " ");
//        }
    }
}
