package com.lefeng.tuning;

public class StaticMethod {

    static class A {
        public static void staticMethod() {

        }
    }

    class B {
        public void instanceMethod() {

        }
    }

    public void test(){
        long Count = 1000000000L;

        long start = System.currentTimeMillis();
        for(long i = 0; i < Count; i++){
            A.staticMethod();
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    public void test2(){
        long Count = 1000000000L;

        B b = new B();

        long start = System.currentTimeMillis();

        for(long i = 0; i < Count; i++){
            b.instanceMethod();
        }

        System.out.println(System.currentTimeMillis() - start);
    }




    public static void main(String[] args) {
        new StaticMethod().test();
        new StaticMethod().test2();
    }
}
