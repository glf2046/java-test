package com.lefeng.primitivetypes;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author guff
 * @since 2019-08-9:16 PM
 */
public class Test1 {

    static class Person{
        private String name;
        private String phone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {

            if(obj instanceof  Person){
                Person p = (Person)obj;
                return p.getName().equalsIgnoreCase(this.name);
            }
            
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.size());

        list.remove(2);

        System.out.println(list.size());

        list.trimToSize();



        Person p1 = new Person();
        p1.setName("a");
        p1.setPhone("b");

        Person p2 = new Person();
        p2.setName("a");
        p2.setPhone("c");

        Hashtable<Person, String> hashtable = new Hashtable<>();
        hashtable.put(p1, "v1");
        hashtable.put(p2, "v2");

        System.out.println(hashtable.size());
    }

}
