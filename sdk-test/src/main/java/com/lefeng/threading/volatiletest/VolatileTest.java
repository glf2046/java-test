package com.lefeng.threading.volatiletest;

public class VolatileTest {
    private volatile Object instance = new Object();

    public void writer() {
        this.instance = new Object();
    }

    public void read() {
        if (instance != null) {
            System.out.println("hello");
        }
    }
}
