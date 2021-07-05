package com.lefeng.CollectionTest;

import java.util.EnumSet;

/**
 * @author guff
 * @since 2020-03-06 03:25
 */
public class EnumSetTest {
    public static void main(String[] args) {
        System.out.println(EnumSet.allOf(ColorA.class));
        System.out.println(EnumSet.noneOf(ColorA.class));
        System.out.println(EnumSet.range(ColorA.YELLOW, ColorA.BLACK));

        System.out.println(A.RED.getCode() | A.YELLOW.getCode() | A.GREEN.getCode());
    }
}

enum ColorA {
    RED, YELLOW, GREEN, BLUE, BLACK, WHITE
}

enum A {
    RED(0), YELLOW(1), GREEN(2), BLUE(4), BLACK(8), WHITE(16);

    private int code;

    A(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
