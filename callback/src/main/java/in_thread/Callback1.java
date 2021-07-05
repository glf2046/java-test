package in_thread;

import java.util.concurrent.CopyOnWriteArrayList;

import common.Callback;
import common.CallbackData;
import common.TargetProcessor;

/**
 * @author guff
 * @since 2020-03-01 15:56
 */
public class Callback1 {

    public static void main(String[] args) {
        TargetProcessor targetProcessor = new TargetProcessor();
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
        Callback callback = new Callback() {
            public void process(CallbackData data, CopyOnWriteArrayList<Integer> list) {
                System.out.println("processed callback: " + data);
                list.add(data.getData());
            }
        };

        targetProcessor.processRequest(1, callback, list);

        for (final Integer integer : list) {
            System.out.println(integer);
        }
    }
}
