package com.lefeng.CollectionTest.sycedCollections;

import java.util.Hashtable;

public class SyncedHashMap {


    //although hashtable is a "synced" structure, i.e. every method has a "synchronized" modifier, somehow
    //it can only make sure the atomicity of that single action, for composite actions, program needs to keep the consistence of stateful data.
    //e.g. in the follow example, thread1 set a value to key1 first, it expect to get its own value, somehow if the put and get operation are not
    //put into the same synchronized block, it will accidentally get the value set by thread2.
    static Hashtable hashtable = new Hashtable();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            synchronized(hashtable) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                hashtable.put("key1", "item1 from thread1");
                System.out.println("thread1's put key1");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(hashtable.get("key1"));
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            hashtable.put("key1", "item1 from thread2");
            System.out.println("thread2's put key1");


        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
