package com.lefeng.SerializationTest;

import java.io.Serializable;

public class B implements Serializable {
    public int year;
    private int brand;

    public B( int year, int brand){
        this.brand = brand;
        this.year = year;
    }

    public String toString(){
        return brand + "," + year;
    }
}
