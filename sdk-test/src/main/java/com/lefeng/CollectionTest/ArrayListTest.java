package com.lefeng.CollectionTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class ArrayListTest {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        testReplace();
    }

    public static void testReplace(){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("item1");
        for(String item : list1){
            System.out.println(item);
        }

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("item1");
        System.out.println(linkedList.get(0));
    }

    public static void testVector(){
        final Vector<Integer> vector = new Vector<>();
        vector.add(0, 0);
        for(int i = 0; i < 10; i++){
            new Thread()
            {
                {
                    for(int i = 0; i < 1000; i++)
                    {
                        try
                        {
                            Thread.sleep(1);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        synchronized (this)
                        {

                            //every new thread will init a new private owned 'this' object, so lock 'this' won't work
                            System.out.println(this);
                            int oldValue = vector.get(0);
                            vector.set(0, ++oldValue);
                        }
                    }
                }
            }.start();
        }

        new Thread().interrupt();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(vector.get(0));
    }
}
