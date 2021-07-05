package com.lefeng.io;

import java.io.*;

public class AbsOrRelativePath {
    public static void main(String[] args) throws IOException {
        System.out.println(AbsOrRelativePath.class.getResource(""));
        System.out.println(AbsOrRelativePath.class.getResource("AbsOrRelativePath.class"));

        System.out.println(AbsOrRelativePath.class.getResource("/"));
        System.out.println(AbsOrRelativePath.class.getClassLoader().getResource("/"));

        System.out.println("############");

        ClassLoader.getSystemResource("AbsOrRelativePath.class");

        Thread.currentThread().getContextClassLoader().getResource("AbsOrRelativePath.class");
        System.out.println("############");

        System.out.println("user.dir:" + System.getProperty("user.dir"));

        //Using File API
//        File file = new File("E:\\Dev\\GitHub\\java-test\\sdk-test\\src\\main\\java\\com\\lefeng\\io\\file\\test.properties");
        File file = new File("sdk-test/src/main/java/com/lefeng/io/file/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }

        file = new File("sdk-test/src/main/resources/test1/test.txt");
        br = new BufferedReader(new FileReader(file));
        while((str = br.readLine()) != null){
            System.out.println(str);
        }

        new AbsOrRelativePath().testResourceAsStream();

    }

    private void  testResourceAsStream(){
        System.out.println("new way");
        InputStream is = this.getClass().getResourceAsStream("/test.properties");
        if(is != null){
            try {
                byte[] bytes = new byte[is.available()];
                is.read(bytes);
                System.out.println(new String(bytes));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


