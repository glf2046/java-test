package type_erasure;

/**
 * @author guff
 * @since 2019-06-7:23 PM
 */
public class TypeErasure {

    public static <T> int count(T[] anArray, T elem) {
        int cnt = 0;
        for (T e : anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }
}
