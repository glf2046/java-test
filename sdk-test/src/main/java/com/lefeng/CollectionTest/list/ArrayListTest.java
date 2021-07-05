package com.lefeng.CollectionTest.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class ArrayListTest {
    static int count = 0;

    public static void main(String[] args) {

    }

    private static void testDeletionWhileTranverse() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(String.valueOf(i));
        }

        //ok to delete by value
//        for (int i = 0; i < 10; i++) {
//            arrayList.remove(String.valueOf(i));
//        }

        //delete by index not ok as size is shrinking as you delete, so will be IndexOutOfBoundException
//        for (int i = 0; i < 10; i++) {
//            arrayList.remove(i);
//            System.out.println("current size: " + arrayList.size());
//        }

        //delete from end is ok since size change does not impact the index earlier
//        for (int i = arrayList.size() - 1; i >= 0; i--) {
//            System.out.println("current size: " + arrayList.size());
//            arrayList.remove(i);
//        }

        //this essentially use iterator, since it will remove which updates the modCount, so will checkForComodification
        //this is essentially the same as below.
//        for (String item : arrayList) {
//            arrayList.remove(item);
//        }


        //use iterator but does not
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            arrayList.remove(iterator.next());
        }

//        Iterator<String> iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            iterator.remove();
//        }

        System.out.println("size: " + arrayList.size());
    }

    private static void test1() throws InterruptedException {
        final Vector<Integer> vector = new Vector<>();
        vector.add(0, 0);
        for (int i = 0; i < 10; i++) {
            new Thread() {
                {
                    for (int i = 0; i < 1000; i++) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (this) {

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

        Thread.sleep(5000);

        System.out.println(vector.get(0));
    }
}
