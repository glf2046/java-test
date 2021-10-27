package streaming;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        IntStream.of(1,2,3).forEach(System.out::println);
        IntStream.range(1,5).forEach(System.out::println);
        IntStream.rangeClosed(1,5).forEach(System.out::println); //包含最后一个元素（inclusive)
    }
}
