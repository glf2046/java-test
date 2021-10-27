package tryWithResource;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

//https://beginnersbook.com/2018/05/java-9-try-with-resources-enhancements/
public class test1 {
    public static void main(String[] args) {

        foo2(new ArrayList());

        try(FileOutputStream fileOutputStream = new FileOutputStream("/Users/guff/Dev/tmp/beginnersbook.txt")){
            //We are writing this string in the output file using FileOutputStream
            String mystring = "We are writing this line in the output file.";

            //Converting the given string in bytes
            byte bytes[] = mystring.getBytes();

            //Writing the bytes into the file
            fileOutputStream.write(bytes);

            //Displaying success message after the successful write operation
            System.out.println("The given String is written in the file successfully");
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static void foo(String... args){
        for(String s : args){
            System.out.println(s);
        }
    }

    public static void foo2(List... names){
        for(List list : names){
            System.out.println(list);
    }
    }
}
