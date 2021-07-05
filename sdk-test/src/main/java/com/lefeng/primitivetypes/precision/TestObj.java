package com.lefeng.primitivetypes.precision;

import java.io.Serializable;

/**
 * @author guff
 * @since 2020-06-09 20:52
 */
public class TestObj implements Serializable {

    @Override
    public String toString() {
        return "TestObj{" +
                "f1=" + f1 +
                ", d1=" + d1 +
                '}';
    }

    private float f1;
    private double d1;

    public TestObj(float f1, double d1) {
        this.f1 = f1;
        this.d1 = d1;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public float getF1() {
        return f1;
    }

    public void setF1(float f1) {
        this.f1 = f1;
    }
}
