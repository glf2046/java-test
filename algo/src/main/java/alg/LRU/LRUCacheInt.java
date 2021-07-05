package alg.LRU;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class LRUCacheInt {

    private int capacity = 0;

    private AtomicInteger size;

    private HashMap<Integer, Integer> hashMap;

    LinkedList<LinkNode> linkedList;

    public LRUCacheInt(int capacity) {
        this.capacity = capacity;
        this.size = new AtomicInteger(0);
        hashMap = new HashMap<>(capacity);
        linkedList = new LinkedList<>();
    }

    public static void main(String[] args) {
//        System.out.println(tableSizeFor(5));
        LRUCacheInt lruCacheInt = new LRUCacheInt(3);

        lruCacheInt.put(1, 1);
        lruCacheInt.put(2, 2);
        lruCacheInt.put(3, 3);
        lruCacheInt.put(4, 4);
        lruCacheInt.put(5, 5);
//        lruCacheInt.put(6, 6);

        print(lruCacheInt);
    }

    private static void print(LRUCacheInt lruCacheInt) {
        for (LinkNode node : lruCacheInt.linkedList) {
            System.out.println(lruCacheInt.hashMap.get(node.getData()));
        }
    }

//    static int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= 10000) ? 10000 : n + 1;
//    }

    public synchronized int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }

        linkedList.removeIf(item -> item.getData() == key);
        linkedList.addFirst(new LinkNode(key));

        return hashMap.get(key);
    }

    public synchronized void put(int key, int value) {
        boolean remove = linkedList.removeIf(node -> node.getData() == key);
        if (!remove) {
            size.incrementAndGet();
        }
        linkedList.addFirst(new LinkNode(key));
        while (size.get() > capacity) {
            int oldestKey = linkedList.getLast().getData();
            hashMap.remove(oldestKey);
            linkedList.removeLast();
            size.decrementAndGet();
        }

        hashMap.put(key, value);
        System.out.println("size: " + hashMap.size());
    }

    static class LinkNode {
        private int data;
        private LinkNode next;
        private LinkNode prev;

        LinkNode(int data) {
            this.data = data;
        }

        public LinkNode getPrev() {
            return prev;
        }

        public void setPrev(LinkNode prev) {
            this.prev = prev;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
