package com.lefeng;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class FileWrite {
    public static void main(String[] args) throws IOException, URISyntaxException {
        testWrite();
    }

    private static void testWrite() throws URISyntaxException, IOException {
        //write to file using getResource
        URI uri = FileWrite.class.getResource("/test/users.txt").toURI();
        System.out.println(FileWrite.class.getResource(""));
        System.out.println(FileWrite.class.getResource("/"));
        System.out.println(FileWrite.class.getResource("/test/users.txt"));
        FileOutputStream fos = new FileOutputStream(new File(FileWrite.class.getResource("/test/users.txt").toURI()));
        //Note, when in running time, the file got written into is not this under "resources" folder, but the one under /Users/guff/Dev/java-test/production/io/test/users.txt
        fos.write("hello 888".getBytes());
        fos.close();

        OutputStream output = new FileOutputStream("/test/users.txt");
        output.write("hello 777".getBytes());
        output.close();
    }

    private static void testRead() throws IOException {
        InputStream inputStream = FileWrite.class.getResourceAsStream("/test/users.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }

}
