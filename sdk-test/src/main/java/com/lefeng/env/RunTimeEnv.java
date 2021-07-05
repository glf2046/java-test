package com.lefeng.env;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class RunTimeEnv {
    public static void main(String[] args) throws InterruptedException {

        ProcessBuilder builder = new ProcessBuilder("java", "com.lefeng.env.HelloWorld");
        builder.environment().put("TEST_ENV2", "v2");
        try {
            builder.redirectOutput(new File("pb.txt"));
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);



//        System.out.println("########################");
//        System.getProperties().list(System.out);
//        System.out.println("#############################");
//        for(Map.Entry<String, String> item : System.getenv().entrySet()){
//            System.out.println(item.getKey() +": " + item.getValue());
//        }
//        new RunTimeEnv().testPropertis2();

    }

    public void testPropertis(){
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream("test.properties"));
            Enumeration enumeration = properties.elements();
            while(enumeration.hasMoreElements()){
                System.out.println(enumeration.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testPropertis2(){
        try {
            Properties properties = new Properties();
            properties.load((InputStream) this.getClass().getClassLoader().getResource("test.properties").getContent());
            Enumeration enumeration = properties.elements();
            while(enumeration.hasMoreElements()){
                System.out.println(enumeration.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
