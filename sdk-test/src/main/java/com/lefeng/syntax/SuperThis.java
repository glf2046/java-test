package com.lefeng.syntax;

public class SuperThis {

    public static void main(String[] args) {
        B b = new B("");
    }

    static class A{

        public A(String name) {
            this.name = name;
            System.out.println(super.getClass());
            System.out.println(this.getClass());

            System.out.println(super.hashCode());
            System.out.println(this.hashCode());
            System.out.println("##############");

        }

        protected String name;
    }

    static class B extends A{

        public B(String name) {
            super(name);
            System.out.println(super.getClass());
            System.out.println(this.getClass());
            System.out.println(super.hashCode());
            System.out.println(this.hashCode());
        }
    }

}
