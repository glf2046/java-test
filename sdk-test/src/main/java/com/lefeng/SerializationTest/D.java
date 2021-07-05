package com.lefeng.SerializationTest;

import java.io.*;
import java.util.Date;

public class D implements Externalizable {

    private static final long serialVersionUID = -8768268687841899448L;
    private String name;
    private int age;
    private long id;

    public D(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public D(){}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(new Date());
        out.writeObject(name);
        out.writeObject(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
         Date date = (Date) in.readObject();
        System.out.println(date);
        this.name = (String)in.readObject();
        this.age = (int)in.readObject();
    }

    public String toString(){
        return age + "," + name + "##";
    }
}
