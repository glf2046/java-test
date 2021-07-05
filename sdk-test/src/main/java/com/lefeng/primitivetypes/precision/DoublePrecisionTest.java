package com.lefeng.primitivetypes.precision;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author guff
 * @since 2020-06-09 17:31
 */
public class DoublePrecisionTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        new DoublePrecisionTest().foo();
        new DoublePrecisionTest().goo();
    }

    void goo(){
        float f1 = 1.0000001f;
        float f2 = 1.0000002f;
        float f3 = 1.0000003f;
        float f4 = 1.0000004f;
        float f5 = 1.0000005f;
        float f6 = 1.0000006f;
        float f7 = 1.0000007f;
        float f8 = 1.0000008f;
        float f9 = 1.0000009f;


        double d1 = f1;
        double d2 = f2;
        double d3 = f3;
        double d4 = f4;
        double d5 = f5;
        double d6 = f6;
        double d7 = f7;
        double d8 = f8;
        double d9 = f9;

        System.out.println(f1 + "  " + d1);
        System.out.println(f2 + "  " + d2);
        System.out.println(f3 + "  " + d3);
        System.out.println(f4 + "  " + d4);
        System.out.println(f5 + "  " + d5);
        System.out.println(f6 + "  " + d6);
        System.out.println(f7 + "  " + d7);
        System.out.println(f8 + "  " + d8);
        System.out.println(f9 + "  " + d9);

        System.out.println(d3/2);
        System.out.println(d4/2);

        System.out.println(f3/2);
        System.out.println(f4/2);

        float f111 = 0.75999997f;
        double d111 = f111;
        System.out.println("f111:" + f111);
        System.out.println("d111:" + d111);

        float f333 = 0.75999996f;
        double d333 = f333;
        System.out.println("f333:" + f333);
        System.out.println("d333:" + d333);

        float f222 = 0.75999992f;
        double d222 = f222;
        System.out.println("f222:" + f222);
        System.out.println("d222:" + d222);

        float f444 = 0.76f;
        double d444 = f444;
        System.out.println(f444);
        System.out.println(d444);

        long bits = Float.floatToIntBits(f111);
        System.out.println(Long.toBinaryString(bits));

        long bits2 = Double.doubleToLongBits(f111);
        System.out.println(Long.toBinaryString(bits2));

        System.out.println("#######################");

        float ff1 = 0.1f;
        long bits3 = Float.floatToIntBits(ff1);
        System.out.println(ff1);
        System.out.println(Long.toBinaryString(bits3));

        double d22 = 0.1f;
        long bits4 = Double.doubleToLongBits(d22);
        System.out.println(d22);
        System.out.println(Long.toBinaryString(bits4));


    }

    void foo() throws IOException, ClassNotFoundException {

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        float f111 = 0.759999992f;
        System.out.println("f111:" + f111);

        float f12 = 0.109999999f;
        System.out.println(f12);
        long bits = Double.doubleToLongBits(0.11);
        System.out.println(Long.toBinaryString(bits));

        long bits2 = Float.floatToIntBits(0.11f);
        System.out.println(Long.toBinaryString(bits2));

        long bits3 = Float.floatToIntBits(0.109999999375f);
        System.out.println(Long.toBinaryString(bits3));

        float f1 = 0.11f;

        System.out.println("#### " + Float.floatToRawIntBits(0.11f));
        System.out.println(f1);

        double d1 = 0.11f;
        System.out.println(d1);
        System.out.println("###########");
        float f2 = 0b00111101111000010100011110101110;
        System.out.println(f2);
        float ff = Float.intBitsToFloat(0b00111101111000010100011110101110);
        System.out.println("ff:" + ff);
        float f3 = 0b01000111101011100011110111100001;
        System.out.println(f3);
        System.out.println("############");
//        ConstantPool.CONSTANT_Float_info info = new ConstantPool.CONSTANT_Float_info(0.1f);
//        System.out.println(info.getTag());
////        System.out.println(info.byteLength());
//        System.out.println(info.value);
//
//        ConstantPool.CONSTANT_Double_info info1 = new ConstantPool.CONSTANT_Double_info(0.11f);
//        System.out.println(info1.getTag());
//        System.out.println(info1.value);

        TestObj testObj = new TestObj(0.11f, 0.11f);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test.obj"));
        outputStream.writeObject(testObj);
        outputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.obj"));
        TestObj newInfo = (TestObj) objectInputStream.readObject();
        System.out.println(newInfo);

        ObjectOutputStream outputStream2 = new ObjectOutputStream(new FileOutputStream("string.obj"));
        outputStream2.writeObject("search_cs");
        outputStream2.close();

        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream("string.obj"));
        String string = (String) objectInputStream2.readObject();
        System.out.println(string);
    }
}
