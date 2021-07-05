package com.lefeng.CollectionTest;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        {

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
}
