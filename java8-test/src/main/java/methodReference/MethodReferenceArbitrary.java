package methodReference;

import java.util.Arrays;
import java.util.Comparator;

public class MethodReferenceArbitrary {
    public static void main(String[] args) {
        String[] stringArray = { "Steve", "Rick", "Aditya", "Negan", "Lucy", "Sansa", "Jon"};
        /* Method reference to an instance method of an arbitrary
         * object of a particular type
         */
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        for(String str: stringArray){
            System.out.println(str);
        }

        //下面两个是等价的
        foo(MethodReferenceArbitrary::aaa);
        foo(new Comparator<MethodReferenceArbitrary>() {
            @Override
            public int compare(MethodReferenceArbitrary o1, MethodReferenceArbitrary o2) {
                return o1.aaa(o2);
            }
        });

        foo(String::compareToIgnoreCase);
    }

    public int aaa(MethodReferenceArbitrary str) {
        return 0;
    }

    private static <T> void foo(Comparator<? super T> c) {
    }
}
