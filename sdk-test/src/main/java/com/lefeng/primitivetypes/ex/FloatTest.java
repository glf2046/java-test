package com.lefeng.primitivetypes.ex;

public class FloatTest {
    public static void main(String[] args) {

        testRawBitsTransformation();
    }

    private static void testRawBitsTransformation() {
        float f0 = 1.1f;
        System.out.println(Float.floatToIntBits(f0));

        double d1 = 1.123d;
        long l1 = Double.doubleToLongBits(d1);
        int i1 = (int)l1;
        System.out.println(l1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(i1);

        System.out.println(7 >>> 1);
        System.out.println(7 >>> 2);
        System.out.println(7 >>> 3);
        float f1 = (float) Math.pow(2, -149);
        System.out.println("#####");
        int i = Float.floatToRawIntBits(f1);
        float f2 = Float.intBitsToFloat(i);
        System.out.println(f2);
        System.out.printf("%.100f", f2);
        System.out.println();
        System.out.printf("%.15e", f2);
        System.out.println();
    }

    private static void testOthers(){
        System.out.println("############ Convert binary string to integer and float ############");
        int t1 = 0b00000000_00000000000000000000001; //same binary string as Float.MIN_VALUE
        System.out.println(t1);
        System.out.println(Integer.toBinaryString(t1));
        System.out.println(Float.intBitsToFloat(t1));

        //Note: This is different from above "int t1 = 0b00000000_00000000000000000000001".
        //Here it essentially directly assign the value "1.0f" to t2, so it's a different value from t1 above.
        float t2 = 0b00000000_00000000000000000000001; //same binary string as Float.MIN_VALUE
        System.out.println(t2);
        System.out.printf("%.100f", t2);
        System.out.println();



        System.out.println("## How Float.MIN_VALUE is represented in binary in memory");
        double min = Math.pow(2, -149);
        System.out.println(min);
        System.out.printf("%.15e", min);  //Same as the default println's output above which is scientific method.
        System.out.println();
        System.out.println("## Convert to float");
        float f2 = (float)min;
        System.out.println(Integer.toString(Float.floatToIntBits(f2), 2));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f2)));
        System.out.printf("%.100f", min);
        System.out.println();

        System.out.println("## Precision issue of calculating float number");
        System.out.println("34.6-34.0=" + (34.6f-34.0f));

        System.out.println("####");
        float f1 = (float)min;
        System.out.println(f1);
        System.out.printf("%.100f", f1);
        System.out.println();
        System.out.printf("%.15e", f1);
        System.out.println();


        System.out.printf("%.100f", (float) Math.pow(2, -150));
        System.out.println();

        System.out.printf("%.100f", Math.pow(2, -151));
        System.out.println();
    }

    private static void testFloatMinValuePrint() {
        System.out.println("## Different output when value equals to Float.MIN_VALUE");
        System.out.printf("%.100f", Math.pow(2, -149));
        System.out.println();
        System.out.printf("%.100f", (float) Math.pow(2, -149));
        System.out.println();
        System.out.println("## Different output when value is smaller than Float.MIN_VALUE");
        System.out.printf("%.100f", Math.pow(2, -151));
        System.out.println();
        System.out.printf("%.100f", (float) Math.pow(2, -151)); //Math.pow(2, -151) is even smaller than Float.MIN_VALUE, so can't present it using float anymore.
        System.out.println();
    }

}
