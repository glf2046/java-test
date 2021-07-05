package com.lefeng.morgan.collectiontest;

import java.util.*;

public class CollectionGeneralTest {

    public static void main(String[] args) {
        testList();
    }

    private static void testArray() {
        String[] strings = new String[2];
        strings[0] = "hello";
        strings[1] = "world";

        for (String string : strings) {
            System.out.printf(string + " ");
        }

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            System.out.printf(string);
        }
    }

    private static void testArraySizzeOverflow() {
        //There are two aspects to the potential OOM error caused by following code:
        // 1. java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        //      cause: you specify an array length >= Integer.MAX_VALUE (Limit can vary on different platform)
        // 2.  OutOfMemory error: Java heap space
        //      cause: The maximum heap space is not enough to hold the array in memory.
        byte[] strings = new byte[Integer.MAX_VALUE - 1];
    }

    private static void testList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.printf(iterator.next() + " ");
        }

        System.out.println("#################");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.printf(s + " ");
        }

        System.out.println("#################");

        //Here if you use 'iterator.remove()' it's fine.
        //but if you use list.remove(item), then there will be concurrent modification exception
        //since during an iteration, you can only use iterator.remove to remove element, any other way will cause the exception aforementioned.
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object item = iterator.next();
            System.out.printf(item.toString());
            iterator.remove();
        }

        //Here it's a 'foreach' statement, it will cause the concurrent modification exception
        //as compiler will essentially turn it to iterator.

    }

    private static void testVector() {
        Vector<String> vector = new Stack<>();
        for (int i = 0; i < 10; i++) {
            vector.add(String.valueOf(i));
        }

        for (int i = 0; i < vector.size(); i++) {
            String s = vector.elementAt(i);
            System.out.printf(s + " ");
        }

        System.out.println("######################");
        Vector<String> newVector = (Vector<String>) vector.clone();

        for (int i = 0; i < newVector.size(); i++) {
            String s = newVector.elementAt(i);
            System.out.printf(s + " ");
        }
    }

    private static void testVectorClone() {
        Vector<Object> vector = new Stack<>();

        MyObject myObject = new MyObject("f1", "f2");
        vector.add(myObject);

        Vector<Object> newVector = (Vector<Object>) vector.clone();
        myObject.field1 = "f11";
        for (int i = 0; i < newVector.size(); i++) {
            Object o = newVector.elementAt(i);
            MyObject myObject1 = (MyObject) o;
            System.out.printf(myObject1.toString());
        }


    }

    private static void testVector3() {
        Vector<String> vector = new Stack<>();
        for (int i = 0; i < 10; i++) {
            vector.add(String.valueOf(i));
        }

        /**
         If does not specify 'new String[]{}' there, then there will be class case exception, 'object[]' can't be casted to 'String[]'.
         */
        String[] strings = vector.toArray(new String[]{});

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            System.out.printf(string + " ");
        }
    }

    //When we need to call 'ensureCapacity' in the first place?
    //When you need to add pretty many elements, if you just repeatively call 'add', then it's not efficient since the underlying array will resize pretty many times and do the array copy.
    //So if you can estimate the necessary capacity needed, then it's more efficient to 'ensureCapacity' beforehand.
    private static void testVectorCapacity() {

        Vector<String> vector = new Stack<>();
        System.out.println(vector.capacity() + " " + vector.size());

        vector.ensureCapacity(11);
        System.out.println(vector.capacity() + " " + vector.size());

        Vector<String> newVector = new Vector<>(10, 3);
        System.out.println(newVector.capacity() + " " + newVector.size());
        newVector.ensureCapacity(11);
        System.out.println(newVector.capacity() + " " + newVector.size());

        //This will cause : java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        newVector.ensureCapacity(Integer.MAX_VALUE);
        System.out.println(newVector.capacity() + " " + newVector.size());

    }

    private static void testVectorComparator() {
        Vector<MyObject> vector = new Vector<>();
        vector.add(new MyObject("f1", "f2"));
        vector.add(new MyObject("f12", "f22"));
        vector.sort(new Comparator<MyObject>() {
            @Override
            public int compare(MyObject o1, MyObject o2) {
                return o1.field1.compareTo(o2.field1);
            }
        });

        vector.sort(new MyComparator());

        for (int i = 0; i < vector.size(); i++) {
            MyObject myObject = vector.elementAt(i);
            System.out.printf(myObject.toString() + " ");
        }
    }


    private static void testHashtable() {
        Hashtable<String, String> hashtable = new Hashtable<>();
    }

    static class MyComparator implements Comparator<MyObject> {
        @Override
        public int compare(MyObject o1, MyObject o2) {
            return -o1.field1.compareTo(o2.field1);
        }
    }

    //Using Comparable is the default(natural ordering), if the comparing logic is not consistent with equals, then you need to clearly point it out.
    //There are two cases you might need 'Comparator':
    // 1. Once you are done with the default 'Comparable' way of sorting, somehow now you want another way of sorting, e.g sorting by other keys.
    // 2. You did not provide the default natural sorting, somehow now you need to compare the keys, e.g. put the object into TreeSet, then you need separate Comparator defined.
    static final class MyObject implements Comparable<MyObject> {
        String field1;
        String field2;

        public MyObject(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        @Override
        public String toString() {
            return field1 + " " + field2;
        }

        @Override
        public int compareTo(MyObject o) {
            return 0;
        }
    }
}
