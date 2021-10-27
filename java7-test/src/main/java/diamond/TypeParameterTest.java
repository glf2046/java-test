package diamond;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guff
 * @since 2019-06-2:12 PM
 */
public class TypeParameterTest {

    static <K, V> Map<K, V> getMap2() {
        return new HashMap<>();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = TypeParameterTest.getMap2();
        System.out.println(map);
    }

}
