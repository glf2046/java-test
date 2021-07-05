package com.lefeng.primitivetypes.precision;

/**
 * @author guff
 * @since 2020-06-15 00:28
 */
public class PrecisionTest2 {
    public static void main(String[] args) {

        double d1 = 0.11f;
        long bits = Double.doubleToLongBits(d1);
        System.out.println(Long.toBinaryString(bits));

        bits = Double.doubleToLongBits(0.11f);
        System.out.println(Long.toBinaryString(bits));

        long bits2 = Float.floatToIntBits(0.11f);
        System.out.println(Long.toBinaryString(bits2));
    }
}
