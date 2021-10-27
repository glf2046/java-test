package diamond;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guff
 * @since 2019-06-9:20 PM
 */
public abstract class DiamondTest<K, V> {

    <K, V> Map<K, V> getMap() {
        return new HashMap<>();
    }

    static <K, V> Map<K, V> getMap2() {
        return new HashMap<>();
    }
}
