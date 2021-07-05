package com.lefeng.SerializationTest;

import java.io.*;

public class ExternlizableTest{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
         D d = new D("name", 12, 1);
        FileOutputStream fos = new FileOutputStream("ExternlizableTest.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);
        fos.flush();

        FileInputStream fis = new FileInputStream("ExternlizableTest.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        D d1 =(D) ois.readObject();
        System.out.println(d1);
    }
}
