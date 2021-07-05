package com.lefeng.morgan;

public class FinalParameter {

    String name;

    int age;

    public FinalParameter(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private static void foo(FinalParameter parameter){
        parameter = new FinalParameter("name2", 100);
    }

    public static void main(String[] args) {
         FinalParameter parameter = new FinalParameter("name1", 10);
        foo(parameter);
        System.out.println(parameter.age);
        System.out.println(parameter.name);
    }
}
