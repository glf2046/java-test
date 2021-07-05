package alg.LRU;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU_2<K, V> {

    private int capacity = 0;

    private HashMap<K, V> hashMap;

    LinkedList<DataItem<V>> linkedList;

    public LRU_2(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity);
        linkedList = new LinkedList<>();
    }

    public V get(K key){
        return hashMap.get(key);
    }

    public V put(K key, V value){
        return hashMap.put(key, value);
    }

    static class DataItem<T>{
        private T data;
    }
}
