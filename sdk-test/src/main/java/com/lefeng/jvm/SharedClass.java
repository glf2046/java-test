package com.lefeng.jvm;

public class SharedClass{
    private SharedClass instance;

    public void setSample(Object instance) {
        this.instance = (SharedClass) instance;
    }
}
