package diamond;

/**
 * @author guff
 * @since 2019-06-9:21 PM
 */
public class Box<T> {

    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}
