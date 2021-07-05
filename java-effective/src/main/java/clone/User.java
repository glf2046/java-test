package clone;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Comparable<User>{

    public static void main(String[] args) {
        new User().test();

        System.out.println(String.valueOf("A".compareTo("a")));
        System.out.println(String.valueOf("A".compareTo("Ab")));
        System.out.println(String.CASE_INSENSITIVE_ORDER.compare("A", "a"));
        System.out.println(String.CASE_INSENSITIVE_ORDER.compare("A", "Ab"));

        testImutableMap();

        //testCaseInsensitive();
    }

    private static void testImutableMap() {

    }

    private static void testCaseInsensitive() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("A");
        list.add("Ab");
        list.add("ab");
        list.add("");
        list.add("abc");

        //list.sort(String::compareTo);
        list.sort(String.CASE_INSENSITIVE_ORDER);

        for(String item : list){
            System.out.println(item);
        }
    }

    private void test(){
        List<User> users = new ArrayList<User>();
        User user1 = new User(12, "name1");
        User user2 = new User(12, "name2");
        User user3 = new User(12, "name3");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        users.sort(User::compareTo);

        for (User user : users) {
            System.out.println(user);
        }
    }

    public User() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name);
    }
}
