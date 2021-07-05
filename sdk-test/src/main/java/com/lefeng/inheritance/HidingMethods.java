package com.lefeng.inheritance;

public class HidingMethods {
    public static void main(String[] args) {
        C.m1();
        D.m1();

        D d = new D();
        d.m1();

        //Method hiding(only applies to static method) follows the early binding rule, while method overriding(non-static inherited methods) follows
        //late binding, this is the only difference in the rules about the redefined method (name, access level, return types, and exception).
        C c = d ;
        c.m1();;
    }
}

class C{
    static void m1(){
        System.out.println("m1 in C");
    }
}

class D extends C {
    static void m1(){
        System.out.println("m1 in D");
    }
}
