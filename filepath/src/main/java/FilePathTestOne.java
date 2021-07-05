import java.io.*;
import java.net.URL;

public class FilePathTestOne {
    public static void main(String[] args) {
        URL fileUrl = FilePathTestOne.class.getResource("/");
        System.out.println("path: " + fileUrl.getPath());
    }

    private static void testWrite() throws IOException {

        String value = "hello 123";

        File file = new File("/log/");

        if(!file.exists()){
            if(!file.mkdir())
                System.out.println("failed to create the dir");
        }else {
            System.out.println("dir already exist");
        }

        File testFile = new File(file, "test.txt");
        if(!testFile.createNewFile())
            System.out.println("failed to create the new file");

        BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));

        writer.write(value);

        writer.flush();

        writer.close();
    }

    private static void testRead() throws IOException {
        File file = new File("/log");

        if(!file.exists() && !file.mkdir()){
            System.out.println("failed to create the dir");
        }

        File testFile = new File(file, "test.txt");
        if(!testFile.createNewFile())
            System.out.println("failed to create the new file");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
