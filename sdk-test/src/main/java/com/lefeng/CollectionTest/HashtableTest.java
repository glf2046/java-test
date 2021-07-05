package com.lefeng.CollectionTest;

import java.util.Hashtable;
import java.util.Map;

public class HashtableTest {
    public static void main(String[] args) {
        testNoHashcodeOverrideKey();
    }

    public static void testNullContains(){
        Hashtable ht = new Hashtable();
        if(ht.contains(null))
            System.out.println("null");
    }

    public static void testNoHashcodeOverrideKey(){
        Hashtable hashtable =new Hashtable();
        Key key1 = new Key("id1", "name1");
        System.out.println(key1.hashCode());

        hashtable.put(key1, "value1");

        key1.setId("id2");
        System.out.println(key1.hashCode());

        hashtable.put(key1, "value2");

        System.out.println();

        for(Object entry : hashtable.entrySet()){
            Map.Entry entry1 = (Map.Entry)entry;
            System.out.println(entry1.getKey() + ", " + entry1.getValue());
        }

    }

    static class Key{
        String id;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Key(String id, String name){
            this.id = id;
            this.name =name;
        }

        @Override
        public String toString() {
            return "[" + id + ", " + name + "]";
        }

    }
}
