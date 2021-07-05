package com.lefeng.CollectionTest;

public class EnumTest {
    public static void main(String[] args) {
        for(Color c : Color.values()){
            System.out.println(c.ordinal());
        }
    }
}

enum Color{
    NONE, RED, GREEN, PURPLE, ORANGE
}
