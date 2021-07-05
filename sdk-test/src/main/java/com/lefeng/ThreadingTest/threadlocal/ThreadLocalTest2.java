package com.lefeng.ThreadingTest.threadlocal;

/**
 * @author guff
 * @since 2019-06-4:09 PM
 */
public class ThreadLocalTest2 {
    private static Item item = new Item("initial value");
    //    private static ThreadLocal<String> item = new ThreadLocal<>();
    private static volatile boolean running = true;

    public static void main(String[] args) {

        Thread readThread = new Thread(() -> {
            while (running) {
                System.out.println(item.getName());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        readThread.start();

        for (int i = 0; i < 50; i++) {
            final int j = i;
            new Thread(() -> {
                item.setName(String.valueOf(j));
            }).start();
        }

        running = false;
    }

    static class Item {
        private String name;

        Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
