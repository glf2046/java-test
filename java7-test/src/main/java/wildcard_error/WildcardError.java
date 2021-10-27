package wildcard_error;

import java.util.List;

/**
 * @author guff
 * @since 2019-06-5:33 PM
 */
public class WildcardError {

    void foo(List<?> i){
        fooHelper(i);
    }

    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

    public static void main(String[] args) {
        List<?> list1;
        List<String> list2 = null;

        list1 = list2;
    }
}
