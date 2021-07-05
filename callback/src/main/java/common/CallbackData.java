package common;

/**
 * @author guff
 * @since 2020-03-01 16:04
 */
public class CallbackData {
    private int data;
    private int signal;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public CallbackData(int data, int signal) {
        this.data = data;
        this.signal = signal;
    }

    @Override
    public String toString() {
        return "data: " + data + ", signal: " + signal;
    }
}
