package super_bound;

/**
 * @author guff
 * @since 2019-06-3:20 PM
 */
public class MyClass<X> {

    <T> MyClass(T t) {

    }

    public static void main(String[] args) {
        MyClass<Integer> myClass = new MyClass<>("");
    }
}

