package com.lefeng.syntax;

public class CloneTest {
    public static void main(String[] args) {
        MyObject o1 = new MyObject();
        try {
            Object o2 = o1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }


    static class MyObject implements Cloneable{
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
