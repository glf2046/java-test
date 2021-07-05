package com.lefeng.ctor;

/**
 * @author guff
 * @since 2020-01-14 02:59
 */
public class CtorMain {
    //https://docs.oracle.com/javase/tutorial/reflect/member/ctorInstance.html
    public static void main(String[] args) {
        try {
            WaysOfCtor waysOfCtor = (WaysOfCtor) Class.forName("com.lefeng.ctor.WaysOfCtor").newInstance();
            System.out.println(waysOfCtor.getF1());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
