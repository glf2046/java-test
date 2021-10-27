package predicate;

import java.util.ArrayList;

/**
 * @author guff
 * @since 2020-01-14 00:58
 */
public class SingleMethodInterfaceTest {

    interface Test<T> {
        boolean test(T value);
    }

    private static Test<String> isEmpty() {
        return p -> p.contains("a");
    }

    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("");
        list.add("abc");
        list.add("lkj");

        for (String item : list) {
            System.out.println(item);
        }
        list.filter(isEmpty());

    }

    static class MyList<E> extends ArrayList<E> {
        void filter(Test<E> test) {
            for (E item : this) {
                if (test.test(item)) {
                    System.out.println(item);
                }
            }
        }
    }

}
