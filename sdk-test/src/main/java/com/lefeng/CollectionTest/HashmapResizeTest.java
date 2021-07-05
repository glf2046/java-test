package com.lefeng.CollectionTest;


import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashmapResizeTest {
    public static void main(String[] args) {
//        HashMap<Key, String> map = new HashMap<>();
//        addElements(map, 0, 16);
//        addElements(map, 16, 32);
//        System.out.println(map.size());
//
//        Set<Key> set = map.keySet();
//        ArrayList<Key> list = new ArrayList<>(set);
//        for (int i = 0; i < 17; i++) {
//             map.remove(list.get(i));
//        }
//
//        System.out.println(map.size());
        testResize();
    }

    private static void testResize(){
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println("initial size: " + map.size());
        for (int i = 0; i < 11; i++) {
            map.put(i, String.valueOf(i));
        }

        System.out.println(map.size());

        for (int i = 12; i < 20; i++) {
            map.put(i, String.valueOf(i));
        }

        System.out.println(map.size());


        Set<Integer> set = map.keySet();
        System.out.println("set size:" + set.size());
        ArrayList<Integer> destList = new ArrayList<>();
        destList.addAll(set);
        
        for (int i = 0; i < 17; i++) {
            map.remove(destList.get(i));
        }

        System.out.println(map.size());

    }

    private static void addElements(HashMap<Key, String> map, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            int sNumber = i%5;
            StringBuilder subKey = new StringBuilder();
            for (int j = 0; j < sNumber; j++) {
                subKey.append("s");
            }
            Key key = new Key(subKey + String.valueOf(i));
            System.out.println(key.key + ":" + key.hashCode());
            map.put(key, "value" + String.valueOf(i));
        }
    }

    static class Key{
        private String key;

        public Key(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object obj) {

            if(this == obj){
                return true;
            }

            if(obj == null|| obj.getClass() != this.getClass()){
                return false;
            }

            Key key = (Key)obj;
            return key.key.equalsIgnoreCase(this.key);
        }

        @Override
        public int hashCode() {
            char[] a = key.toCharArray();
            int numberOfChar = 0;
            for (int i = 0; i < a.length; i++) {
                if(!NumberUtils.isDigits(String.valueOf(a[i]))){
                    numberOfChar++;
                }
            }

            char[] result = new char[numberOfChar];
            for (int i = 0, j=0; i < a.length; i++) {
                if(!NumberUtils.isDigits(String.valueOf(a[i]))){
                    result[j++] = a[i];
                }
            }

            int hashCode;
            if(result.length != 0){
                hashCode = String.valueOf(result).hashCode();

            }else{
                hashCode = "".hashCode();
            }

            return hashCode;
        }
    }
}
