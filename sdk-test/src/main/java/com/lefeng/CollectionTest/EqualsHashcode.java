package com.lefeng.CollectionTest;

import java.util.HashMap;

public class EqualsHashcode {

    private static class Person{
        int idCard;
        String name;

        public Person(int idCard, String name) {
            this.idCard = idCard;
            this.name = name;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            Person person = (Person) o;
            //两个对象是否等值，通过idCard来确定
            return this.idCard == person.idCard;
        }
    }
    public static void main(String []args){
        HashMap<Person,String> map = new HashMap<Person, String>();
        Person person = new Person(1234,"name1");
        Person person1 = new Person(1234,"name1");
        //put到hashmap中去
        map.put(person,"value123");
        //get取出，从逻辑上讲应该能输出“天龙八部”
        System.out.println("result:"+map.get(person));
        System.out.println("result:"+map.get(person1));

    }
}
