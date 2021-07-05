package com.lefeng.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.springframework.util.Assert;

//https://www.baeldung.com/cglib
public class CGLibMain {
    public static void main(String[] args1) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor)(obj, method, args, proxy)->{
            if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                System.out.println("calling:" + method.getName());
                return "Hello Tom!";
            }else{
                proxy.getClass().getName();
                System.out.println("calling:" + method.getName());
                return proxy.invokeSuper(obj, args);
            }
        });

        PersonService proxy = (PersonService)enhancer.create();

        String res = proxy.sayHello("mary");

        System.out.println("res: " + res);

        int lengthOfName = proxy.lengthOfName("Mary");

        System.out.println("lengthOfName: " + lengthOfName);

        Assert.isTrue(lengthOfName == 4);

        Assert.isTrue("Hello Tom!".equals(res));
    }
}
