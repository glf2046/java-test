package com.lefeng.primitivetypes.ex.newfeature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class Java7 {

    //try with resource
    static String readFirstLineFromFile(String path, String zipFileName, Path outputFilePath, Charset charset) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }



    //init list with collection of elements
    static void initElements(){

    }
}
