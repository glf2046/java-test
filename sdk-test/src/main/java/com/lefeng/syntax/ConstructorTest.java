package com.lefeng.syntax;

public class ConstructorTest {
    public static void main(String[] args) {
        Test t1 = new Test(1);
        System.out.println(t1);
    }


    ConstructorTest(int k, int i) {
        this(k);    // Second statement. A compile-time error, it must be the first element in the constructor.
    }

    ConstructorTest(int x) {
    }

    static class Test{
        private int x, y;

        public Test(int value) {
            if (value < 0) {
                return;
            }
            x = value;
            y = value * 2;
            /* Perform some logic here */
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
}
