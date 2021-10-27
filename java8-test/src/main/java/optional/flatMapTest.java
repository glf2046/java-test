package optional;

import java.util.ArrayList;
import java.util.Optional;

//https://beginnersbook.com/2017/10/java-8-optional-class/
public class flatMapTest {
    public static void main(String[] args) {
        //Creating Optional object from a String
        Optional<String> GOT = Optional.of("Game of Thrones");
        //Optional.empty() creates an empty Optional object
        Optional<String> nothing = Optional.empty();
        System.out.println(GOT.map(String::toLowerCase));
        System.out.println("nothing£º" + nothing.map(String::toLowerCase));
        Optional<Optional<String>> anotherOptional = Optional.of(Optional.of("BreakingBad"));
        System.out.println("Value of Optional object" + anotherOptional);
        System.out.println("Optional.map: "
                + anotherOptional.map(gender -> gender.map(String::toUpperCase)));
        //Optional<Optional<String>>    -> flatMap -> Optional<String>
        System.out.println("Optional.flatMap: "
                + anotherOptional.flatMap(gender -> gender.map(String::toUpperCase)));
    }
}
