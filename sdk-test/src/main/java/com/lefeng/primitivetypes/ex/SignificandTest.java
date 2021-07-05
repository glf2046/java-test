package com.lefeng.primitivetypes.ex;

public class SignificandTest {
    public static void main(String[] args) {

        System.out.format("%.30f", Math.pow(2, -23) + Math.pow(2, -24));
        System.out.println();
        System.out.format("%.30f", Math.pow(2, -22));
        System.out.println();
        System.out.format("%.30f", Math.pow(2, -23));
        System.out.println();

        System.out.println("#### diff");
        System.out.format("%.30f", Math.pow(2, -24));
        System.out.println();
        System.out.format("%.30f", Math.pow(2, -22) - Math.pow(2, -23) - Math.pow(2, -24));
        System.out.println();

        System.out.println(Integer.toBinaryString(Float.floatToIntBits((float)Math.pow(2, -23) + (float)Math.pow(2, -24))));

        //essentially the mantissa is "1.1"
        int t1 = 0b0_10111111_10000000000000000000000;
        float o1 = Float.intBitsToFloat(t1);
        System.out.format("%.20f", o1);
        System.out.println();

        //essentially the mantissa is "1.11"
        int t2 = 0b0_10111110_11000000000000000000000;
        float o2 = Float.intBitsToFloat(t2);
        System.out.format("%.20f", o2);
        System.out.println();

        //essentially the mantissa is "1.00"
        int t3 = 0b0_01111111_00000000000000000000000;
        float o3 = Float.intBitsToFloat(t3);
        System.out.format("%.20f", o3);
        System.out.println();



        System.out.println("###### Rounding test");

        //1. this is about the rounding.
        //binary number: 0.011(0.375)
        //if only can keep two digit places at most, then it can either round up to 0.1(0.5) or round down to 0.01(0.25)
        //they have the same precision and deviation from the original number is the same.
        //that's why you see f1+f2 below generates a output of "1011111110000000000000000000010" in binary string, actually it should be
        //"10111111100000000000000000000011" which has one more digit place, but it's round up to the former value.


        //2. When adding a smaller number to a existent float number, if the smaller one is Math.pow(2, 24) times less than the existent one,
        //then probably you won't see the addition work as expected, as in order to keep the same exponent which is kept the same as the existent number's exponent,
        //so the smaller number need to move the significand to the right by 24 digit places, obviously all the significand will be out of the scope.
        //but there is one exception that if the digit place right after the decimal point is "1", then there will be rounding, so after moved to the right
        //by 24 digit places, the 23th digit place in the significand part will be "1" instead of zero, somehow all left will be zero.

        int i1 = 0b0_10111111_10000000000000000000000;
        float f1 = Float.intBitsToFloat(i1);
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(f1)));
        System.out.format("%.100f", f1);
        System.out.println();

        int i2 = 0b0_10101000_10000000000000000000000;
        float f2 = Float.intBitsToFloat(i2);
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(f1 + f2)));
        System.out.format("%.100f", f1+f2);
        System.out.println();

        int i3 = 0b0_10100111_10000000000000000000000;
        float f3 = Float.intBitsToFloat(i3);
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(f1 + f3)));
        System.out.format("%.100f", f1 + f3);
        System.out.println();

        int i4 = 0b0_10100110_10000000000000000000000;
        float f4 = Float.intBitsToFloat(i4);
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(f1 + f4)));
        System.out.format("%.100f", f1 + f4);
        System.out.println();

        int i5 = 0b0_10100101_10000000000000000000000;
        float f5 = Float.intBitsToFloat(i5);
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(f1 + f5)));
        System.out.format("%.100f", f1 + f5);
        System.out.println();


    }
}
