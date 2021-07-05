package com.lefeng.generic;

/**
 * @author guff
 * @since 2019-12-05 22:26
 */
public class B extends A {

    public B(String f1, String f2) {
        super(f1);
        this.f2 = f2;
    }

    private String f2;

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    @Override
    public String toString() {
        return getF1() + ":" + f2;
    }
}
