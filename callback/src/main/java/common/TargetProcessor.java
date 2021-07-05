package common;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author guff
 * @since 2020-03-01 16:06
 */
public class TargetProcessor {
    public void processRequest(int request, Callback callback, CopyOnWriteArrayList<Integer> list){
        System.out.println("processing request: " + request);

        int signal = 1;

        CallbackData data = new CallbackData(request, signal);
        callback.process(data, list);
    }
}
