package com.lefeng.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Properties;

public class JVMEncodingTest {
    public static void main(String[] args) {
        System.out.println(getJVMEnconding());
        getJVMParams();
    }
    // ���jvm��Ĭ�ϱ���
    public static String getJVMEnconding() {
        return System.getProperty("file.encoding");
    }

    //��ȡJVM����
    public static void  getJVMParams() {
        try {
            Properties properties=System.getProperties();
            PrintWriter out=null;
            out = new PrintWriter(new File("a.txt"));
            properties.list(out);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
