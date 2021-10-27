package wildcard_error;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guff
 * @since 2019-06-5:40 PM
 */
public class WildcardErrorBad {

    //https://docs.oracle.com/javase/tutorial/java/generics/wildcardGuidelines.html
    public static void main(String[] args) {
        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
//        ln.add(new NaturalNumber(35));  // compile-time error

    }
}

class NaturalNumber{
    public NaturalNumber(int i) {
    }
}

class EvenNumber extends NaturalNumber{
    public EvenNumber(int i) {
        super(i);
    }
}
