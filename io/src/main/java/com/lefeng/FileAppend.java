package com.lefeng;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class FileAppend {
    public static void main(String[] args) throws IOException, URISyntaxException {
        FileWriter fw = new FileWriter(new File(FileAppend.class.getResource("/write.txt").toURI()).getAbsoluteFile(),true);
        fw.write("hello");
        fw.append("world");
        fw.append("123");
        fw.write("456");

        fw.flush();
        fw.close();
    }
}
