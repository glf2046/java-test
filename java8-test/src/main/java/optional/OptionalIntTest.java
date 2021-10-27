package optional;

import java.util.OptionalInt;
import java.util.function.IntConsumer;

/**
 * @author guff
 * @since 2019-04-1:47 PM
 */
public class OptionalIntTest {
    public static void main(String[] args) {
        OptionalInt optionalInt = OptionalInt.of(10);
        System.out.println(optionalInt.getAsInt());

        System.out.println(optionalInt.orElse(0));

        IntConsumer intConsumer = value -> System.out.println("accept: " + value);

        IntConsumer intConsumer1 = intConsumer.andThen(value -> System.out.println("and then: " + value));

        optionalInt.ifPresent(intConsumer1);

    }
}
