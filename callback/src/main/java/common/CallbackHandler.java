package common;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author guff
 * @since 2020-03-01 16:05
 */
public class CallbackHandler implements Callback {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void process(CallbackData data, CopyOnWriteArrayList<Integer> list) {
        System.out.println("process result: " + data);

        state = data.getData() + 1;
        list.add(state);
    }
}
