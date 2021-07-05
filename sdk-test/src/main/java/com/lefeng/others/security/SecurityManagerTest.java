package com.lefeng.others.security;

import java.io.*;

public class SecurityManagerTest {
    public static void main(String[] args) {
        System.out.println("SecurityManager: " + System.getSecurityManager());
        try {
            FileReader  fr = new FileReader("E:\\Dev\\GitHub\\java-test\\sdk-test\\src\\main\\java\\com\\lefeng\\others\\security\\protect.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            try {
                while((s = br.readLine()) != null){
                    System.out.println(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(System.getProperty("file.encoding"));
    }
}
