package com.lefeng.SerializationTest;

import java.io.*;
import java.lang.reflect.Field;

public class SerializationTest1 {
    public static void main(String[] args) {
        A a1 = new A("name1", 22, 1.0f);
        B b1 = new B(11, 33);
        C c1 = new C("c1", "c2");

        try {
            FileOutputStream fos = new FileOutputStream("a1.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a1);
            oos.writeObject(b1);
            fos.flush();
            fos.close();

            FileInputStream fis =new FileInputStream("a1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            //read the objects in the same order of serialization
            A a = (A) ois.readObject();
            System.out.println(a);

            B b = (B)ois.readObject();
            System.out.println(b);

            Class clazz = b.getClass();
            System.out.println(clazz);
            for(Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                System.out.println(field.getName() + "," + field.getInt(b));
            }



            Field fieldB = clazz.getDeclaredField("brand");
            fieldB.setAccessible(true);
            System.out.println(fieldB.getInt(b));


            Class clazzC = c1.getClass();
            for(Field field : clazzC.getDeclaredFields()){
                System.out.println(field.get(c1).toString());
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static class A implements Serializable {
        private static final long serialVersionUID = 2148097373586298037L;
        String name;
        int age;
        transient float price;

        public A(String name, int age, float price){
            this.name = name;
            this.age = age;
            this.price = price;
        }

        public String toString(){
           return name + "," + age + "," + price;
        }
    }
}
