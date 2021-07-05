package cross_thread;

import java.util.concurrent.CopyOnWriteArrayList;

import common.Callback;
import common.CallbackData;
import common.CallbackHandler;
import common.TargetProcessor;

/**
 * @author guff
 * @since 2020-03-01 15:56
 */
public class Callback1 {

    public static void main(String[] args) throws InterruptedException {
        final TargetProcessor targetProcessor = new TargetProcessor();
        final CallbackHandler callback = new CallbackHandler();
        final CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            final int j = i;
            Thread t1  = new Thread(new Runnable() {
                public void run() {
                    targetProcessor.processRequest(j, callback, list);
                }
            });

            t1.start();
            t1.join();
        }

        for (final Integer item : list) {
            System.out.println(item);
        }

    }
}
