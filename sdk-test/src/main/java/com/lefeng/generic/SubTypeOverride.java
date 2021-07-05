package com.lefeng.generic;

public class SubTypeOverride {
    public static void main(String[] args) {
        Class clazz = SubTypeOverride.class;
        System.out.println(clazz.getModifiers());
    }

    class E{

    }
}

class S{
  void f1(Object o){

  }
}

class T extends S {
    @Override
    protected void f1(Object i){

    }
}
