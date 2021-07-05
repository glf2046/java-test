
import java.util.*;

///https://www.journaldev.com/16635/collections-class-java-util-collections
//
public class CollectionsTest {
    public static void main(String[] args) {
        testMax();
    }

    private static void testMax(){

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");
        list.add("c");
        list.add("b");
                
        String index = Collections.max(list, String::compareTo);
        System.out.println(index);
    }

    //when wrapped using "mutex", it's not yet threading safe, for composite operation, you still need to make sure the integration/consistence of stateful data.
    // e.g. 'add' is synced, somehow if you have an operation which checks if a element is already in the list, if true, then add it, otherwise do nothing.
    //in multiple threading environment, you 
    private static void testSynchronized(){

        List list = new ArrayList();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("a");

        List<String> newList = Collections.synchronizedList(list);

        //will throw UnsupportedOperationException, since the underlying SingletonSet just implement AbstractSet partially
        newList.add("b");
        for(String item : newList){
            System.out.printf(item);
        }
    }

    private static void testUnmodifiable(){

        List list = new ArrayList();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("a");

        List<String> newList = Collections.unmodifiableList(list);

        //will throw UnsupportedOperationException, since the underlying SingletonSet just implement AbstractSet partially
        newList.add("b");
        for(String item : newList){
            System.out.printf(item);
        }
    }

    private static void testSingleton(){

        Set<String> set = Collections.singleton("a");

        //will throw UnsupportedOperationException, since the underlying SingletonSet just implement AbstractSet partially
        set.add("b");
        for(String item : set){
            System.out.printf(item);
        }
    }

    private static void testFrequency(){
        List list = new ArrayList();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("a");

        int a = Collections.frequency(list, "a");
        System.out.println("frequency: " + a);
    }


    private static void testEmptySetList(){
        List list = Collections.emptyList();
        for(Object o: list){
            System.out.println(o);
        }

        Set set = Collections.emptySet();
        Map map = Collections.emptyMap();


    }

    @SuppressWarnings("unchecked")
    private static void CollectionsOther(){
        List list = new ArrayList();
        List<String> typedList = Collections.checkedList(list, String.class);
        typedList.add("hello");
    }

    private static void CollectionsListMethod() {
        Vector v = new Vector();

        // populate the vector
        v.add("A");
        v.add("B");
        v.add("C");
        v.add("D");
        v.add("E");

        // create enumeration
        Enumeration e = v.elements();

        // get the list
        ArrayList arrlist = Collections.list(e);

        System.out.println("Value of returned list: " + arrlist);

    }

    private static void CollectionsSort(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("b");

        //you can either use Collectons.sort(List<T> list) or Collections.sort(List<T> list, Comparator<T> comparator)
        //or you can directly use list.sort() which accept lamda expression and method reference or new Comparator Object
        //which essentially implements the "compare(T t1, T t2) method.
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

//        list.sort(((o1, o2) -> o1.compareTo(o2)));
//        list.sort(String::compareTo);

        for(String item : list){
            System.out.println(item);
        }
    }

    private static void Sets() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("b");

        Set<String> set2 = new HashSet<>();
        set2.add("x");
        set2.add("y");


        Collections.addAll(set2, "z");

        for(String item : set2){
            System.out.println(item);
        }


        set2.addAll(set);
        for(String item : set2){
            System.out.println(item);
        }
    }
}
