package com.lefeng.test.syntax.static_class;

public class StaticClassTest {

    private int count;

    private static int age;

    public static void main(String[] args) {
        TestClass2 class2 = new TestClass2();
        System.out.println(class2.size);

        TestStaticClass testStaticClass = new TestStaticClass();
        System.out.println(testStaticClass.size);
        System.out.println(testStaticClass.length);
        ;
        
    }

    static class TestStaticClass{

        protected int size;

        private final int length = 0;

        TestStaticClass(){}

        TestStaticClass(int size, int length) {
            this.size = size;
        }
    }

    private static class TestClass2 extends TestStaticClass{

    }
}
