package com.lefeng.syntax;

public class ConstructorStrangeTest {
}

class Foo {
    int i;

    Foo() {
        i = 1;
        int x = getValue();
        System.out.println(x);
    }

    protected int getValue() {
        return i;
    }
}

class Bar extends Foo {
    int j;

    Bar() {
        j = 2;
    }

    @Override
    protected int getValue() {
        return j;
    }
}

class InstanceInitializer {
    private int j = getI();
    private int i = 1;

    public InstanceInitializer() {
        i = 2;
    }

    private int getI() {
        return i;
    }

    public static void main(String[] args) {
        InstanceInitializer ii = new InstanceInitializer();
        System.out.println(ii.j);
    }
}


