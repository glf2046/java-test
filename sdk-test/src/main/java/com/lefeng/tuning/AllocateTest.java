package com.lefeng.tuning;

import java.nio.ByteBuffer;

public class AllocateTest {
    public static void main(String[] args) {
        ByteBuffer.allocate(1024);
        ByteBuffer.allocateDirect(1024);

//        Unsafe.getUnsafe().allocateInstance(this.getClass());
//        Unsafe.getUnsafe().allocateMemory(1024L);
//        Unsafe.getUnsafe().reallocateMemory(1024L, 2048L);
//        Unsafe.getUnsafe().addressSize();
//        Unsafe.getUnsafe().monitorExit();
    }
}
