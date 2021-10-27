package wildcard_inheritance_subtypes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guff
 * @since 2019-06-3:53 PM
 */
public class WildCardSubType {

    public static void main(String[] args) {
        List<?> list = new ArrayList<>();

        List<? extends Number> numbers = new ArrayList<>();

        List<Integer> integerList = new ArrayList<>();
        List<? extends Integer> integerWildlist = new ArrayList<>();

        list = numbers;

        numbers = integerList;

        numbers = integerWildlist;

        integerWildlist = integerList;

        List<Number> numbers2 = new ArrayList<>();
        List<? extends Number> numberWildlist = new ArrayList<>();

        numberWildlist = numbers2;

        List<? extends Number> numberWildlist2 = new ArrayList<Integer>();

        numberWildlist2 = numbers2;


    }
}
