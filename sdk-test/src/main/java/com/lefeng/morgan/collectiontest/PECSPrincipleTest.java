package com.lefeng.morgan.collectiontest;

import java.util.ArrayList;
import java.util.List;

public class PECSPrincipleTest {
    public static void main(String[] args) {
        List<? extends Foo> list1 = new ArrayList<>();
        List<? extends Foo> list2 = new ArrayList<>();

         /* Won't compile */
        //list2.add( new Foo() ); //error 1
        //list1.addAll(list2);    //error 2
    }
     /**
        从上述两方面的分析，总结PECS原则如下：

        如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
        如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
        如果既要存又要取，那么就不要使用任何通配符。
      */

    static class Foo{
        public Foo(){
            
        }
    }
}
