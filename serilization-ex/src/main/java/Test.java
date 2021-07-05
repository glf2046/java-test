import java.io.File;

public class Test {

    static FileTest fileTest;
    public static void main(String[] args) {
        try{
            fileTest = new FileTest(0);
            System.out.println(fileTest.file);
            System.out.println(fileTest.hashCode());
            System.out.println(fileTest.toString());

        }catch (RuntimeException e){
            System.out.println(fileTest);
            System.out.println(fileTest.hashCode());
            System.out.println(fileTest.toString());
            System.out.println(fileTest.file);
        }
    }

    static class FileTest{
        File file;

        public FileTest(int i){
            if(i == 0)
                throw new RuntimeException("");
            file = new File(".");//get current directory
        }
    }
}
