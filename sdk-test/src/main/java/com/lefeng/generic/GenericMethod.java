package com.lefeng.generic;

import java.util.List;

public class GenericMethod {
    public static void main(String[] args) {
        //Pair p1 = new Pair<>("1", "value1");
        //Pair p2 = new Pair<>("2", "value2");

        Pair p3 = new Pair<>(new D(), "value1");
        Pair p4 = new Pair<>(new D(), "value2");
        Util.compare(p3, p4);

        String[] arr = {"a", "b", "e"};
        String element = "c";
        System.out.println(countNumberGreaterThan(arr, element));
    }

    public static <T extends Comparable<T>> int countNumberGreaterThan(T[] array, T element){
        int result = 0;

        for(T t : array){
            if(t.compareTo(element) > 0){
              result++;
            }
        }

        return result;
    }

    public static double sumOfListInteger(List<Integer> list) {
        double s = 0.0;
        for (Integer n : list)
            s +=n;
        return s;
    }
}


//Bounded Type Parameters
class Util {
    public static <K extends A1 & B1 & C1, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        System.out.println("Comparing...");
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}

//Multiple Bounds
class Pair<K extends A1 & B1 & C1, V> implements Comparable<Pair<K,V>>{
    private K key;
    private V value;

    public Pair(K k, V v){
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        return 0;
    }
}

class A1 { /* ... */ }

interface B1 { /* ... */ }

interface C1 { /* ... */ }

class D extends A1 implements B1, C1 {

}



