package com.lefeng.env;

import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {

        if(System.getenv().containsKey("TEST_ENV2")){
            System.out.println("contains");
        }
        for (Map.Entry<String, String> item : System.getenv().entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }

        System.out.println("hello world 030");
    }
}
