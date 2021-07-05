package com.lefeng;

import java.io.IOException;

public class AssertTest {
    public static void main(String[] args) {
        try {
            int s = System.in.read();
            assert s != 10;
            System.out.println("input is: " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
