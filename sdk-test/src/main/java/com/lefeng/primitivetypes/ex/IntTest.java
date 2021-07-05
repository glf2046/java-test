package com.lefeng.primitivetypes.ex;

public class IntTest {
    public static void main(String[] args) {
        System.out.println("############ convert int to binary string ############");
        int i1 = Integer.MAX_VALUE - 1;
        System.out.println(Integer.toBinaryString(i1));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        int i2 = Integer.MIN_VALUE + 1;
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE + 10));
        System.out.println(Integer.toBinaryString(i2));

        System.out.println("############ convert binary string to int ############");
        //These binary strings are the actual strings representing the number in memory, under debug mode, you can see from debug window(view as binary)
        int i3 = 0b1111111111111111111111111111110;
        int i4 = 0b1111111111111111111111111111111;
        int i5 = 0b10000000000000000000000000000000;
        int i6 = Integer.MIN_VALUE + 1;
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
        System.out.println(Integer.toBinaryString(i6));
        System.out.println((int) Math.pow(2, 31)); //int type only uses 31 bits to represent its value
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(-100));
        int t1 = 0b00100000000000000000000000000000;
        System.out.println(t1);



        System.out.println("########## Java SE 8: to handle 'int' as if they were unsigned ########");
        //        Java has no unsigned integers.
        //
        //                You can define a long instead of an int if you need to store large values but there's no way to exclude negative values.
        //
        //        However, as of Java SE 8, there are a few new methods in the Integer class which allow you to use the int data type to perform unsigned arithmetic:
        //        #################################################################################################################################################################
        //        "In Java SE 8 and later, you can use the int data type to represent an unsigned 32-bit integer, which has a minimum value of 0 and a maximum value of 2^32-1.
        //        Use the Integer class to use int data type as an unsigned integer.
        //        Static methods like compareUnsigned, divideUnsigned etc have been added to the Integer class to support the arithmetic operations for unsigned integers."
        //        #################################################################################################################################################################
        //        Note that int variables are still signed when declared but unsigned arithmetic is now possible by using those methods in the Integer class.
        //
        int a = 1;
        int b = 2;
        System.out.println(Integer.compareUnsigned(a, b));

        int c = -1;
        //'c' will be taken as an unsigned number so it's greater than 'b'.
        System.out.println(Integer.compareUnsigned(c, b));


        System.out.println("########## Java SE 8: to handle 'long' as if they were unsigned ########");
        long l1 = 1;
        long l2 = 2;
        System.out.println(Long.compareUnsigned(l1, l2));

        long l3 = -1;
        //'l3' will be taken as an unsigned number so it's greater than 'l2'.
        System.out.println(Long.compareUnsigned(l3, l2));

        long l4 = Integer.MAX_VALUE * 10;
        System.out.println(l4);
        long l5 = (long) Integer.MAX_VALUE *10;
        System.out.println(l5);

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
    }
}
