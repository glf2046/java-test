package com.lefeng.proxy.cglib;

import net.sf.cglib.proxy.Mixin;
import org.springframework.util.Assert;

public class MixinMain {
    public static void main(String[] args) {
        Mixin mixin = Mixin.create(new Class[]{interface1.class, interface2.class, MixinInterface.class}, new Object[]{new Class1(), new Class2()});

        MixinInterface mixinInterface = (MixinInterface)mixin;
        Assert.isTrue("first behavior".equals(mixinInterface.first()));
        Assert.isTrue("second behavior".equals(mixinInterface.second()));
    }

    static interface interface1{
        String first();
    }

    static class Class1 implements interface1{

        @Override
        public String first() {
            return "first behavior";
        }
    }

    static interface interface2{
        String second();
    }

    static class Class2 implements interface2{

        @Override
        public String second() {
            return "second behavior";
        }
    }

    static interface MixinInterface extends interface2, interface1{

    }
}
