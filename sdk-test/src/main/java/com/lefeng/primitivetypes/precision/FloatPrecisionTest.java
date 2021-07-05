package com.lefeng.primitivetypes.precision;

import java.text.DecimalFormat;

/**
 * @author guff
 * @since 2020-04-09 15:35
 */
public class FloatPrecisionTest {
    public static void main(String[] args) {
//            check0();
        checkOverflow();
        checkPrecision1();
    }

    private static void checkPrecision1() {
        System.out.println("################");
        System.out.println(0.5f);
        System.out.println(0.1f);
        System.out.println(0.3f);
        System.out.println(0.05 + 0.01);


    }

    private static void checkOverflow() {
        System.out.println("################");

        float f1 = 1234567.1f;
        float f2 = 1234567.12f;
        float f3 = 5234567.12f;
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
    }

    private static void check0(){

        String b1 = "0.1";
        String b2 = "0.2";
        double dd = Double.parseDouble(b1) + Double.parseDouble(b2);
        System.out.println(dd);
        System.out.println(dd == 0.3);

        //when you specify a numeric value with decimal points, by default jvm take it as a 'double' value.
        //so for : System.out.println((0.1 + 0.2) == 0.3), output is false, as 0.1 essentially is not cleanly '0.1', it's a infinite loop.
        //so (0.1+0.2) is actually 0.30000000000000004, so they are not equal to 0.3, but if you use float type, since float can only
        //present precision of 7~8 digits, so they can not distinguish the subtle/tiny difference between 0.30000000000000004 and 0.3,
        //so the output will be true.
        double t1 = 0.1f;
        double t2 = 0.2f;
        double t3 = t1 + t2;
        double t4 = 0.3f;
        System.out.println(t3 == t4);

        System.out.println((0.1 + 0.2) == 0.3);

        System.out.println((0.1 + 0.2));

        System.out.println( 2.1 * 100 );//210.0
        float f1 = 2.1f;
        int i = 100;
        System.out.println( f1 * i );//209.99998
        System.out.println( f1 * 100 );//209.99998

    }

    private static void check() {
        float f1 = 0.33f;
        float f2 = 0.67f;

        boolean isEqual = (f1 + f2) == 1.0;
        System.out.println(isEqual);
    }

    private static void check2() {
        float f1 = Float.parseFloat("0.33");
        float f2 = Float.parseFloat("0.33");
        float f3 = Float.parseFloat("0.33");

        boolean isEqual = (f1 + f2 + f3) == 1.0;
        System.out.println(isEqual);
    }

    private static void check3() {
        float f1 = Float.parseFloat("0.33");

        boolean isEqual = (f1) == 0.33;
        System.out.println(isEqual);
    }

    private static void check4() {
        float f0 = 1.39e-43f;
        float f1 = 0.35f;
        float f2 = 0.65f;
        float f3 = 0;

        System.out.println(8E-6);
        System.out.println(new DecimalFormat("0.000000000").format(2E-6));
        System.out.println(new DecimalFormat("0.000000000").format(2E6));

        boolean isEqual = (f1 + f2 + f3) == 1.0;
        System.out.println(isEqual);
    }
}
