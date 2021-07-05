package com.lefeng.jvm.JOL;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class JOLSample_26_IHC_BL_Conflict {
    public static void main(String[] args) throws InterruptedException {
        out.println(VM.current().details());

        TimeUnit.SECONDS.sleep(6);

        final A a = new A();

        ClassLayout layout = ClassLayout.parseInstance(a);

        out.println("**** Fresh object");
        out.println(layout.toPrintable());

        synchronized (a) {
            out.println("**** With the lock");
            out.println(layout.toPrintable());
        }

        out.println("**** After the lock");
        out.println(layout.toPrintable());

        int hashCode = a.hashCode();
        out.println("hashCode: " + Integer.toHexString(hashCode));
        out.println();

        out.println("**** After the hashcode");
        out.println(layout.toPrintable());

        synchronized (a) {
            out.println("**** With the second lock");
            out.println(layout.toPrintable());
        }

        out.println("**** After the second lock");
        out.println(layout.toPrintable());
    }

    static class A {
        // no fields
    }
}
