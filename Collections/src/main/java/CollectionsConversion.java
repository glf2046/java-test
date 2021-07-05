import java.util.*;

public class CollectionsConversion {
    public static void main(String[] args) {
        setToList();
    }

    private static void arrayToSet() {
        String[] array = new String[3];
        array[0] = "hello";
        array[1] = "world";
        array[2] = "test";

        //unordered
        Set<String> set = new HashSet<>(Arrays.asList(array));

        for (String item : set) {
            System.out.println(item);
        }
    }

    private static void setToArray() {
        //unordered
        Set<String> set = new HashSet<>(Arrays.asList("hello", "world", "test"));

        Object[] array = set.toArray();
        String[] newArray = set.toArray(new String[0]);

        for (Object item : array) {
            System.out.println(item);
        }

        System.out.println("##########");

        for (String item : newArray) {
            System.out.println(item);
        }
    }


    private static void listToSet() {

        List<String> list = Arrays.asList("hello", "world", "test");

        //unordered
        Set<String> set = new HashSet<>(list);
        for (String item : set) {
            System.out.println(item);
        }

    }

    private static void setToList() {

        List<String> list = Arrays.asList("hello", "world", "test");

        //unordered
        Set<String> set = new HashSet<>(list);

        List<String> newList = new ArrayList<>(set);

        for (String item : newList) {
            System.out.println(item);
        }
    }

    private static void arrayToListThenToArray() {
        String[] array = new String[3];
        array[0] = "hello";
        array[1] = "world";
        array[2] = "test";

        for (String item : array) {
            System.out.println(item);
        }

        List<String> list = Arrays.asList(array);
        for (String item : list) {
            System.out.println(item);
        }

        Object[] newArray = list.toArray();
        for (Object o : newArray) {
            System.out.println(o);
        }

    }

    private static void testAddAllPlusSort() {
        List<String> fruits = new ArrayList<>();
        Collections.addAll(fruits, "banana", "apple", "pear");

        fruits.forEach(System.out::println);

        Collections.sort(fruits, Comparator.comparing(String::toString));

        fruits.forEach(System.out::println);

    }

    private static void testbinarySearch2() {
        List<String> fruits = new ArrayList<>();
        Collections.addAll(fruits, "banana", "apple", "pear");
        Collections.sort(fruits);
        System.out.println(Collections.binarySearch(fruits, "Banana"));
        System.out.println(Collections.binarySearch(fruits, "pear"));
    }

    private static void testasLifoQueue() {
        Deque deque = new LinkedList();
        deque.addFirst("Apples");
        deque.add("Oranges");
        deque.addLast("Bananas");

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.poll());

        Queue queue = Collections.asLifoQueue(deque);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static void testbinarySearch4() {

    }

    private static void testbinarySearch5() {

    }

    private static void testbinarySearch6() {

    }
}
