package functionalInterface;

import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

public class IntBinaryOperatorTest {
    public static void main(String args[]) {
        // lambda expression
        IntBinaryOperator sum = (a, b) -> a + b;
        System.out.println("Result: " + sum.applyAsInt(12, 100));

        LongBinaryOperator multiply = new LongBinaryOperator() {

            @Override
            public long applyAsLong(long left, long right) {
                return left * right;
            }
        };

    }
}
