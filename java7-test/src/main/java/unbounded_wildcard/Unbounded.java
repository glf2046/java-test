package unbounded_wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guff
 * @since 2019-06-3:33 PM
 */
public class Unbounded {

    public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void printList2(List<?> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();

        printList(objectList);

        List<String>  stringList = new ArrayList<>();
        printList2(stringList);

    }
}
