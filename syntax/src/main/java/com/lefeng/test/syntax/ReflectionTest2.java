package com.lefeng.test.syntax;

import sun.reflect.Reflection;

 class ReflectionTest2 {
    void test2(){
        System.out.println("test2");
        System.out.println(Reflection.getCallerClass(1).getName());

        //public class :33
        //package class : 32
        System.out.println(Reflection.getClassAccessFlags(this.getClass()));

        System.out.println(Reflection.getCallerClass(0).getName());
        System.out.println(Reflection.getCallerClass(1).getName());
        System.out.println(Reflection.getCallerClass(2).getName());

    }
}
