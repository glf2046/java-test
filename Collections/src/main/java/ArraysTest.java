import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        Arrays();
    }

    private static void Arrays(){
        String[] array = new String[3];
        array[0] = "hello";
        array[1] = "world";
        array[2] = "test";

        int index = Arrays.binarySearch(array, "hello");
        System.out.println("index: " + index);

        //'newLength' parameter limits the number of records in the newArray, of less than the original array, then trim the extra elements.
        //if bigger than original number, then padding with default 'null' values
        String[] newArray = Arrays.copyOf(array, 2);
        
        for(String item : newArray){
            System.out.println(item);
        }

        System.out.println("##############");

        String[] array2 = new String[3];
        for (int i = 0; i < 3; i++) {
            array2[i] = null;
        }

        String o = "A";
        System.out.println(o);
        Arrays.fill(array2, o);

        for(String item : array2){
            System.out.println(item);
        }

        //recursive calculate the hashcode of the embedding array values
        System.out.println(Arrays.deepHashCode(array));

        //just calculate the hashcode of the first level array values
        System.out.println(Arrays.hashCode(array));
    }
}
