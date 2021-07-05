package threading_pattern;

import java.util.concurrent.atomic.AtomicInteger;

public class SIngle_Threaded_Execution {

    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Gate gate = new Gate();
        UserThread userThread1 = new UserThread(gate, "alice", "alaska");
        UserThread userThread2 = new UserThread(gate, "blice", "blaska");
        UserThread userThread3 = new UserThread(gate, "clice", "claska");
        userThread1.start();
        userThread2.start();
        userThread3.start();

        Thread.sleep(1000);
        running = false;
    }

    static class Gate {
        private int count = 0;
        private String name = "nobody";
        private String address = "nowhere";

        public void pass(String name, String address) {
            count++;
            this.name = name;
            this.address = address;
            check();
        }

        private void check() {
            if (name.charAt(0) != address.charAt(0)) {
                System.out.println("Time: " + System.currentTimeMillis() + ", ####### broken #######, " + toString());
            }

            System.out.println("counter: " + count);
        }

        @Override
        public String toString() {
            return "Gate{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    static class UserThread extends Thread {
        private final Gate gate;
        private String name;
        private String address;

        UserThread(Gate gate, String name, String address) {
            this.gate = gate;
            this.name = name;
            this.address = address;
        }

        @Override
        public void run() {
            while (running) {
                synchronized (gate) {
                    //                        Thread.sleep(10);
                    gate.pass(name, address);
                }
            }
        }
    }
}
