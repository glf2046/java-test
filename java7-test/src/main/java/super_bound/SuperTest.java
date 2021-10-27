package super_bound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guff
 * @since 2019-06-2:19 PM
 */
public class SuperTest {

    public static void addNumbers(List<? super Object> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

//    public static void addNumbers(List<? extends Number> list) {
//        list = new ArrayList<Integer>();
//        for (int i = 1; i <= 10; i++) {
//            list.add(Integer.valueOf(i));
//        }
//    }
//
//    public void addCat(List<? super Cat> catList) {
//        catList.add(new Animal());
//        System.out.println("Cat Added");
//    }

    public static double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list)
            sum += n.doubleValue();
        return sum;
    }

    public static void printAll(List<?> list) {
        for (Object item : list)
            System.out.println(item + " ");
    }

    public static void main(String args[]) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sum(integerList));

        List<Double> doubleList = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sum(doubleList));
    }

}
