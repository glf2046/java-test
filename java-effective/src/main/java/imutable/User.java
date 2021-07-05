package imutable;


import sun.rmi.server.UnicastServerRef;

import java.util.*;

public class User implements Comparable<User>{

    public static void main(String[] args) {

        testImutableMap();

        User u1= new User(23, "name1");
        User u2= new User(23, "name1");
        System.out.println(u1.equals(u2));
        System.out.println(u1.equals1(u2));
        System.out.println(u1.hashCode());
        System.out.println(u1.hashCode1());
        u1.setAge(20);
        System.out.println(u1.hashCode());
        System.out.println(u1.hashCode1());


        //testCaseInsensitive();
    }

    private static void testImutableMap() {
        Map<User, String> map = new HashMap<>();

        User user1 = new User(10, "user1");
        map.put(user1, "value1");

        System.out.println("value: " + map.get(user1));

        user1.setAge(20);

        System.out.println("value: " + map.get(user1));
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(User o) {

        int temp = this.age - o.age;
        if(temp != 0){
            return temp;
        }else
            return this.name.compareTo(o.name);
    }

    public boolean equals1(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    public int hashCode1() {

        return Objects.hash(age, name);
    }
}
