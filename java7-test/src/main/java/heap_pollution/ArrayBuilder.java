package heap_pollution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guff
 * @since 2019-06-7:47 PM
 */
public class ArrayBuilder {
    public static <T> void addToList(List<T> listArg, T... elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }


    @SafeVarargs
    public static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = l[0].get(0);       // ClassCastException thrown here
    }

    public static void main(String[] args) {

        List<String> stringListA = new ArrayList<>();
        List<String> stringListB = new ArrayList<>();

        ArrayBuilder.addToList(stringListA, "Seven", "Eight", "Nine");
        ArrayBuilder.addToList(stringListB, "Ten", "Eleven", "Twelve");
        List<List<String>> listOfStringLists = new ArrayList<>();
        ArrayBuilder.addToList(listOfStringLists,
                stringListA, stringListB);

        ArrayBuilder.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));

        cast();
    }

    @SuppressWarnings("unchecked")
    public static void cast(){
        List list = new ArrayList();
        list.add("");
    }

}
