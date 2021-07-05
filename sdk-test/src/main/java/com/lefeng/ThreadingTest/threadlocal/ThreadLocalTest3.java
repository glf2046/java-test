package com.lefeng.ThreadingTest.threadlocal;

import java.util.ArrayList;

/**
 * @author guff
 * @since 2019-06-4:09 PM
 */
public class ThreadLocalTest3 {
    public static Item item = new Item("-1");

    public static void main(String[] args) {

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int j = i;
            threads.add(new Thread(() -> {
                ThreadLocalTest3.item.setName(String.valueOf(j));
            }));


        }

        for(Thread thread : threads){
            thread.start();
            System.out.println(ThreadLocalTest3.item.getName());
        }


    }

    static class Item {
        private String name;

        public Item(String name) {
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
