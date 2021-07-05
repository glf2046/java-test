package com.lefeng.test.syntax;

import sun.reflect.Reflection;

import java.lang.reflect.Field;

public class ReflectionTest {

    public String s1;

    protected String s2;

    private String s3;

    public static final String s4 = null;

    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz = ReflectionTest.class;

        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields){
            System.out.println(f.getName() + ": " +  f.getModifiers());
        }


        System.out.println("#####################");

        
        ReflectionTest instance = new ReflectionTest();
        Class instanceClazz = instance.getClass();
        Field[] fields1 = instanceClazz.getDeclaredFields();

        for (Field f : fields1){
            f.setAccessible(true);
            System.out.println(f.getName() + ": " +  f.getModifiers());
        }

        Field field = instanceClazz.getDeclaredField("s2");
        try {
            field.set(instance, "s1 value");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(field.get(instance));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println("#####################");
        System.out.println(Reflection.getCallerClass(1).getName());

        new ReflectionTest2().test2();
    }

    private static void test1() {
    }
}
