package function;

import java.util.function.Function;

/**
 * @author guff
 * @since 2019-06-8:44 PM
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<Float, Integer> function = new Function<Float, Integer>() {
            @Override
            public Integer apply(Float f) {
                return f.intValue();
            }
        };

        Integer integer = function.apply(25.10F);
        System.out.println(integer);

        Function<Integer, Integer> function1 = Function.identity();

        System.out.println(function1.apply(100));

        Function<Integer, Integer> function2 = MethodClassOne::a;

        System.out.println(function2.apply(10));

        Function<Integer, Integer> function3 = new FunctionTest()::do2;

        System.out.println(function3.apply(null));

    }

    public Integer do2(Integer integer) {
        return Integer.MAX_VALUE;
    }
}
