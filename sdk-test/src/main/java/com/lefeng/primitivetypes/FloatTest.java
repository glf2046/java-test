package com.lefeng.primitivetypes;

public class FloatTest {
    public static void main(String[] args) {
        float a, b, c;
        a = 12345679.0f;
        b = 12345678.0f;
        c = 1.01233995f;

        float s = (a+b+c)/2.0f;

        System.out.println(s);
        System.out.println(s -a );
        System.out.println(s -b);
        System.out.println(s -c);

        double da, db, dc, ds;
        da = 12345679.0d;
        db = 12345678.0d;
        dc = 1.01233995d;
        ds =(da +db + dc)/2.0f;
        System.out.println(ds);
        System.out.println(ds -da );
        System.out.println(ds -db);
        System.out.println(ds -dc);
    }
}
