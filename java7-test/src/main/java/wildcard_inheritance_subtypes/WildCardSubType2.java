package wildcard_inheritance_subtypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guff
 * @since 2019-06-3:53 PM
 */
public class WildCardSubType2 {

    //https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html

    /**
     * An "in" variable is defined with an upper bounded wildcard, using the extends keyword.
     An "out" variable is defined with a lower bounded wildcard, using the super keyword.
     In the case where the "in" variable can be accessed using methods defined in the Object class, use an unbounded wildcard.
     In the case where the code needs to access the variable as both an "in" and an "out" variable, do not use a wildcard.
     * A list defined by List<? extends ...> can be informally thought of as read-only, but that is not a strict guarantee
     * @param args
     */
    public static void main(String[] args) {
        List<B> listA = new ArrayList<>();
        listA.add(new B());

        List<? super B> list2 = new ArrayList<>();
        list2.add(new D());
        list2 = listA;

        for (B item : listA){
            list2.add(item);
            System.out.println(item);
        }

        for(Object item : list2){
            System.out.println(item);
        }

        List<?> list = new ArrayList<>();
        List<? super A> superAs = new ArrayList<>();
        superAs.add(new A());
        superAs.add(new B());
        superAs.add(new D());

        List<A> as = new ArrayList<>();

        List<? super B> superBs = new ArrayList<>();
//        superBs.add(new A());
        superBs.add(new B());
        superBs.add(new D());
        List<B> bs = new ArrayList<>();

        list = as;

        superAs = as;

        superBs = superAs;

        superBs = bs;

        processSuperAs(superAs);
        processSuperBs(superAs);

        List<B> bbs = new ArrayList<>();
        processSuperBs(bbs);
        processSuperBbs(bs);

        A a = new A();
        B b = new B();

        a = b;

        processA(b);
//        processB(a);


        

    }

    public static void processSuperAs(List<? super A> list){
        processSuperBs(list);
    }

    public static void processSuperBbs(List<B> list){
        processSuperBs(list);
    }

    public static void processSuperBs(List<? super B> list){
        List<B> bs = Arrays.asList(new B());

        for (B item : bs){
            list.add(item);
        }

    }

    public static void processA(A a){}

    public static void processB(B b){}

}

class A{}

interface C{}

class B extends A implements C{}

class D extends B{}
