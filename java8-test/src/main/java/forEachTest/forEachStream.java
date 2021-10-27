package forEachTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class forEachStream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("na1");
        names.add("name2");
        names.add("name3");

        names.stream().filter((s -> s.length() > 3)).forEach(System.out::println);

        //Will keep the order exactly as the source list.
        names.stream().filter((s -> s.length() > 3)).forEachOrdered(System.out::println);

        System.out.println("###############");
        List<String> words = new ArrayList<String>();
        words.add("your");
        words.add("name");

        Stream<Stream<Character>> result = words.parallelStream().map(w -> characterStream(w));
        for (Stream s : result.collect(Collectors.toList())) {
            System.out.println(s.collect(Collectors.toList()));
        }

        //flatMap可以把不同的流整合到一起
        Stream<Character> letters = words.parallelStream().flatMap(w -> characterStream(w));
        System.out.println(letters.collect(Collectors.toList()));
    }

    public static Stream<Character> characterStream(String s){
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray())
            result.add(c);
        return result.stream();
    }
}
