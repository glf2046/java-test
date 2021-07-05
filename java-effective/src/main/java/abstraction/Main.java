package abstraction;

import java.util.AbstractList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List list = intArrayAsList(new int[]{1, 3, 2, 100});
        System.out.println(list.size());
        System.out.println(list.add(10));
        System.out.println(list.size());

    }
    // List adapter for int array
    static List intArrayAsList(final int[] a) {
        if (a == null)
            throw new NullPointerException();
        return new AbstractList() {
            public Object get(int i) {
                return a[i];
            }
            public int size() {
                return a.length;
            }
            public Object set(int i, Object o) {
                int oldVal = a[i];
                a[i] = (Integer) o;
                return oldVal;
            }
        };
    }
}
