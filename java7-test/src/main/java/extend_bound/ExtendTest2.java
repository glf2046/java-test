package extend_bound;

import java.util.Arrays;
import java.util.List;

/**
 * @author guff
 * @since 2019-06-3:24 PM
 */
public class ExtendTest2 {

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static double addToList(List<? super Number> list) {
        list.add(new NumberEx());
        System.out.println("20D added");
        return 0D;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5);

        System.out.println("sum: " + sumOfList(list));

        List<Double> list2 = Arrays.asList(1D, 3D, 5D);

        System.out.println("sum: " + sumOfList(list2));

        System.out.println("###############");

    }

}

class NumberEx extends Number{

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
