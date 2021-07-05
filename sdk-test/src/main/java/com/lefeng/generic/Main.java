package com.lefeng.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guff
 * @since 2019-12-05 22:28
 */
public class Main {
    public static void main(String[] args) {

        C c1;
        c1 = new C<>("f32");
        System.out.println(c1.getF3());

        List<? extends A> aList = new ArrayList<A>();
//        aList.add(new A("f11"));
//        aList.add(new A("f12"));

        List<B> bList = new ArrayList<>();
        bList.add(new B("f11", "f21"));
        bList.add(new B("f12", "f22"));

        aList = bList;

        bList = (List<B>) aList;

        System.out.println(aList);
        System.out.println(bList);

    }
}
