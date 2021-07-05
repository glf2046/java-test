package com.lefeng;

import java.net.URL;

public class ClassLoaderTest {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

        //same value as below
        System.out.println(System.getProperty("sun.boot.class.path"));


        System.out.println("################### extension class loader ################");

        //NetworkClassLoader loader;

        //same value as below
        System.out.println(System.getProperty("sun.boot.class.path"));


        System.out.println("################");
        System.out.println(System.getenv());
        System.out.println("###############");
        System.out.println(System.getProperties());
    }
}
