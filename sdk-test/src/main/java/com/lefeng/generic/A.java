package com.lefeng.generic;

import java.util.Objects;

/**
 * @author guff
 * @since 2019-12-05 22:26
 */
public class A {
    private String f1;

    public A(String f1) {
        this.f1 = f1;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    @Override
    public String toString() {
        return Objects.toString(f1);
    }
}
