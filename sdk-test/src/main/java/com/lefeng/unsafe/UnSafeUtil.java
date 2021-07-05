package com.lefeng.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSafeUtil {
    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            /* ... */
        }

        return null;
    }
}
