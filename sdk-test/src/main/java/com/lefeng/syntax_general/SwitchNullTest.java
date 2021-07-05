package com.lefeng.syntax_general;

/**
 * @author guff
 * @since 2020-08-16 13:32
 */
public class SwitchNullTest {
    public static void main(String[] args) {
        method(null);
    }

    private static void method(String o) {
        switch (o){
            case "a":
                System.out.println("a");
                break;
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
