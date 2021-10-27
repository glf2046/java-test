package methodReference;

import java.util.Arrays;

public class MethodReferenceArbitrary2 {
    public static void main(String[] args) {

        User[] users = {new User(13, "name1"), new User(12, "name2")};

        System.out.println();

        Arrays.sort(users, UserComparator::compare2);
        Arrays.sort(users, User::compare);

        for(User str: users){
            System.out.println(str);
        }
    }

    static class User{

        private int age;
        private String name;

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int compare(User user){
            return this.age - user.age;
        }
    }

    static class UserComparator {
        public static int compare2(User o1, User o2) {
            return o1.compare(o2);
        }
    }
}
