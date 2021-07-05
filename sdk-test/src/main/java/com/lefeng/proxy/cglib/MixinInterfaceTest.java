package com.lefeng.proxy.cglib;

import net.sf.cglib.proxy.Mixin;

/**
 * @author guff
 * @since 2020-01-07 22:19
 */
public class MixinInterfaceTest {
    interface Interface1{
        String first();
    }
    interface Interface2{
        String second();
    }

    class Class1 implements Interface1{
        @Override
        public String first() {
            return "first";
        }
    }

    class Class2 implements Interface2{
        @Override
        public String second() {
            return "second";
        }
    }

    interface MixinInterface extends Interface1, Interface2{

    }

    class A implements MixinInterface {

        @Override
        public String first() {
            return null;
        }

        @Override
        public String second() {
            return null;
        }
    }

    public void testMixin() throws Exception{
        Mixin mixin = Mixin.create(new Class[]{Interface1.class, Interface2.class,
                MixinInterface.class}, new Object[]{new Class1(),new Class2()});
        MixinInterface mixinDelegate = (MixinInterface) mixin;
//        assertEquals("first", mixinDelegate.first());
//        assertEquals("second", mixinDelegate.second());
    }
}
