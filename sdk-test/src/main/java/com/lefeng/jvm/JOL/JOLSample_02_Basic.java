package com.lefeng.jvm.JOL;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.GraphLayout;

import java.util.HashMap;

@Slf4j
public class JOLSample_02_Basic {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 13; i++) {
            hashMap.put(i + "abc", i + "def");

        }
        log.info("{}", GraphLayout.parseInstance(hashMap).toPrintable());

//        A a = new A();
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
//        B b = new B();
//        System.out.println(ClassLayout.parseInstance(b).toPrintable());
//        C c = new C();
//        System.out.println(ClassLayout.parseInstance(c).toPrintable());
//        int[] aa = new int[0];
//        System.out.println(ClassLayout.parseInstance(aa).toPrintable());
    }

    public static class A {
    }

    public static class B {
        private long s;
    }

    public static class C {
        private int a;
        private long s;
    }

    int[] aa = new int[0];
}
