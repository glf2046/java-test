package extend_bound;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guff
 * @since 2019-06-2:15 PM
 */
public class ExtendTest<T extends Comparable> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    <U> Map<T, U> getMap(){
        return new HashMap<>();
    }

    public static void main(String[] args) {
        ExtendTest<String> extendTest = new ExtendTest<>();
        Map<String, Integer> map = extendTest.getMap();
        System.out.println(map);
    }
}
