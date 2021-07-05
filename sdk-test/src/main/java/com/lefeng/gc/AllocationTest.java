package com.lefeng.gc;

public class AllocationTest {

    private static final int ONEMB = 1 << 20;

    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[ONEMB << 1];
        allocation2 = new byte[ONEMB << 1];
        allocation3 = new byte[ONEMB << 1];
        allocation4 = new byte[ONEMB << 2];
    }
}
