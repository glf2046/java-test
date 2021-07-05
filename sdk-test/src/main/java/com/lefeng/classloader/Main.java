package com.lefeng.classloader;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("hello");
            Class.forName("com.lefeng.classloader.TestClass");

            System.out.println(sun.misc.Launcher.getBootstrapClassPath().getURLs()[0]);
            System.out.println(sun.misc.Launcher.getLauncher());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
