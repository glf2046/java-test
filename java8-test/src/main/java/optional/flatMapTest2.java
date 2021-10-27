package optional;


import java.util.Optional;

//https://beginnersbook.com/2017/10/java-8-optional-class/
public class flatMapTest2 {
    public static void main(String[] args) throws Exception {

        User user1 = Optional.ofNullable(getUserById(1))
                .orElseThrow(() -> new Exception("user no"));
        System.out.println(user1);

        User user2 = Optional.ofNullable(getUserById(1))
//                .filter(user -> user.getUserName().length() > 10)
                .orElseGet(() -> new User("user2"));
        System.out.println(user2);

        String username = Optional.ofNullable(getUserById(0))
                .map(User::getUserName)
                .orElse("Unknown");
        System.out.println("userName: " + username);


        Optional.ofNullable(getUserById(1))
                .map(User::getUserName)
                .flatMap((name)-> Optional.of(name.toLowerCase()))
                .ifPresent(name -> System.out.println("Username is: " + name));

//        Optional<String> optionalUser = Optional.ofNullable(getUser())
//                .map(User::getUserName)
//                .map(String::toLowerCase)
//                .map(name -> name.replace('_', ' '))
//                .orElse("user2");
    }

    public static User getUserById(int n){
        if (n == 0) {
            return null;
        }
        return new User("user1");
    }
}
