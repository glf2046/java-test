package com.lefeng;

public class Outter {
    private Inner inner;
    private int age;

    public Inner getInnerInstance(){
        if(inner == null)
            inner = new Inner();
        return inner;
    }


    protected class Inner{
        public Inner(){

        }
    }
}
