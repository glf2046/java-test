package common;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author guff
 * @since 2020-03-01 16:04
 */
public interface Callback {
    void process(CallbackData data, CopyOnWriteArrayList<Integer> list);
}
