package com.lefeng.CollectionTest.set;

import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(7);
        System.out.println(bitSet.size());
        for(int i =0; i < bitSet.size(); i++){
            System.out.println(bitSet.get(i));
        }

        System.out.println(bitSet.length());
    }
}
