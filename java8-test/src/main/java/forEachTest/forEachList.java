package forEachTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class forEachList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Pear");
        fruits.add("Mango");
        //lambda expression in forEach Method
        fruits.forEach(System.out::println);

        fruits.forEach(System.out::println);

        fruits.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
