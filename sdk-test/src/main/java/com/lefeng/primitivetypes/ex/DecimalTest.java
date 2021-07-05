package com.lefeng.primitivetypes.ex;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DecimalTest {
    public static void main(String[] args) {
        //In Java, neither float or double can be used for accurate decimal calculation, and unlike C#, there is no 'decimal' type in java,
        //but there is 'BigDecimal' type in java which is accurate, but it does not support all operator level operation.

        System.out.println("######## add operation");
        //directly using double for calculation
        System.out.println(0.05+0.01);
        //Use the constructor accepting double as argument
        //this is not accurate sometime as the double can't represent the exact number sometime.
        BigDecimal bd1 = new BigDecimal(0.05);
        BigDecimal bd2 = new BigDecimal(0.01);
        System.out.println(bd1.add(bd2));
        //Better use the constructor accepting string as argument
        BigDecimal bd3 = new BigDecimal("0.05");
        BigDecimal bd4 = new BigDecimal("0.01");
        System.out.println(bd3.add(bd4));

        System.out.println("######## subtract operation");
        BigDecimal a = new BigDecimal("2.23");
        BigDecimal b = new BigDecimal("1.93");
        System.out.println(a.subtract(b));

        System.out.println("######## multiply operation");
        BigDecimal c = new BigDecimal("2.23");
        BigDecimal d = new BigDecimal("1.93");
        System.out.println(a.multiply(b));

        System.out.println("######## divide operation");
        BigDecimal e = new BigDecimal("2.23");
        BigDecimal f = new BigDecimal("1.93");
        System.out.println(a.divide(b,3, RoundingMode.UP));

        BigDecimal g = new BigDecimal("123456789.123456888", new MathContext(4, RoundingMode.UP));
        System.out.println("g=" + g);
        System.out.println(g.signum());
        System.out.println(g.precision());
        System.out.println(g.scale());

        BigDecimal h = new BigDecimal("123456789.123456888".toCharArray(), 4, 12);
        System.out.println("bd1=" + h);
        System.out.println(h.signum());
        System.out.println(h.precision());
        System.out.println(h.scale());
    }
}
