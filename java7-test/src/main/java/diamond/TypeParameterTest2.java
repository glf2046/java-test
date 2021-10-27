package diamond;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guff
 * @since 2019-06-2:12 PM
 */
public class TypeParameterTest2 {

    <K, V> Map<K, V> getMap() {
        return new HashMap<>();
    }

    public static void main(String[] args) {
        TypeParameterTest2 typeParameterTest2 = new TypeParameterTest2();
        Map<String, Integer> map = typeParameterTest2.getMap();
        System.out.println(map);
    }
}
