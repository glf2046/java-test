package com.lefeng.env;

public class GetEnv {
    public static void main(String[] args) {
        System.out.println(System.getenv("PATH"));
        System.out.println("############");
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("############");
        //need to add jvm arg : -DTestArg=123
        
        System.out.println(System.getProperty("TestArg"));
    }
}
