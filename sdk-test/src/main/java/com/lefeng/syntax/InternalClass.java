package com.lefeng.syntax;

public class InternalClass {
    public static void main(String[] args) {
        InternalClass internalClass = new InternalClass("hello");
        InternalClass.B b = internalClass.new B();
        b.foo();
    }

    public InternalClass(String a) {
        this.a = a;
    }

    public void foo1(){
        new B().foo();
    }

    private String a;
    private static String b;

    class B{
        private int a;

        public void foo(){
            System.out.println(InternalClass.this.a);
            System.out.println(a);
        }

        public void foo2(String value){
            System.out.println(value);
        }

        public void bar(){
            System.out.println(InternalClass.b);
        }
    }
}
