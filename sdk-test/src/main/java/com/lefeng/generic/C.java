package com.lefeng.generic;

/**
 * @author guff
 * @since 2019-12-06 00:54
 */
public class C<E> {

    public C(E f3) {
        this.f3 = f3;
    }

    private E f3;

    public E getF3() {
        return f3;
    }

    public void setF3(E f3) {
        this.f3 = f3;
    }
}
