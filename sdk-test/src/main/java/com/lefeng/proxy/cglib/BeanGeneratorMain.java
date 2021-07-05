package com.lefeng.proxy.cglib;

import net.sf.cglib.beans.BeanGenerator;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanGeneratorMain {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "some string value set by cglib");

        Method getter = myBean.getClass().getMethod("getName");
        Assert.isTrue("some string value set by cglib".equals(getter.invoke(myBean)));
    }
}
