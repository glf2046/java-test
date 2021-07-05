package com.lefeng.primitivetypes.ex.newfeature;

import java.math.BigDecimal;

public class BinaryLiberalTest {
    public static void main(String[] args) {
        int a = 0b00001111;
        long b = 123456789L;
        float c = 8888L;
        int h = 0x24;
        byte i = 0x25;
        short j = 0x26;
        long k = 0x27;
        long k1 = 0x27_12_25;
        long k3 = 1_2_3L;
        System.out.println(k3);

        //Down-casting
        Integer g3 = 200;
        System.out.println(g3.byteValue());
        //Up-casting
        System.out.println(g3.longValue());

        //Integer and Long as unsigned value
        System.out.println(Integer.parseUnsignedInt("2147483649", 10));

        byte d = 127;
        byte d1 = -128;
        short e = 32767;
        short e1 = -32768;
        int g = 2147483647;
        int g1 = -2147483648;
        boolean f = false;
        boolean t = true;
        double r = 14d;
        double r1 = 16;
        double r3 = 1.234e2;
        double r4 = 123.4;
        char t1 = 'a';
        System.out.println(t1);
        char t2 = '\u0032';
        System.out.println(t2);

        char t3 = 0x32;
        System.out.println(t3);

        char t4 = '\r';
        System.out.println(t4);

        char t5 = 32;
        System.out.println(t5);

        //Print out the max/min/exponent
        //Note: For Boolean, its "size" isn't something that's precisely defined
        System.out.println("Static constant fields");
        //1.Byte
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.SIZE);
        System.out.println(Byte.BYTES);
        //2.Char
        System.out.println(Character.MAX_VALUE);
        System.out.println(Character.MIN_VALUE);
        System.out.println(Character.SIZE);
        System.out.println(Character.BYTES);
        System.out.println(Character.UNASSIGNED);
        System.out.println(Character.SURROGATE);
        System.out.println(Character.getType('?'));;
        System.out.println(Character.MAX_HIGH_SURROGATE);
        System.out.println(Character.MIN_HIGH_SURROGATE);
        System.out.println(Character.MIN_LOW_SURROGATE);
        System.out.println(Character.MIN_LOW_SURROGATE);
        //3.Short
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.SIZE);
        System.out.println(Short.BYTES);
        //4.Integer
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.BYTES);
        //5.Long
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.SIZE);
        System.out.println(Long.BYTES);
        //6.Decimal
        System.out.println(BigDecimal.ONE);
        System.out.println(BigDecimal.TEN);
        System.out.println(BigDecimal.ROUND_CEILING);
        System.out.println(BigDecimal.ROUND_FLOOR);
        System.out.println(BigDecimal.ROUND_UP);
        System.out.println(BigDecimal.ROUND_DOWN);
        System.out.println(BigDecimal.ROUND_HALF_DOWN);
        System.out.println(BigDecimal.ROUND_HALF_UP);
        System.out.println(BigDecimal.ROUND_UNNECESSARY);

        //how to hold the results of divided and multiplied operations
        int z1 = Integer.MAX_VALUE;
        int z2 = Integer.MAX_VALUE;
        int z3 = z1 * z2;

        float z4 = Float.MAX_VALUE;
        float z5 = Float.MAX_VALUE;
        float z6 = z4 * z5;



        //Breach the threshold so compiler alerts and complains.
        //short e = 32769;
        //byte l = 128;
        int m = 2147483647;
        System.out.println(a);
    }
}
