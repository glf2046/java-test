package com.lefeng.proxy.dynamic.invocationproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author guff
 * @since 2019-06-6:19 PM
 */
public class InvocationProxyTest2 {
    //main 函数
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassA a = new ClassA();
        MyInvotion myInvotion = new MyInvotion(a);
        Class myProxy = Proxy.getProxyClass(ClassA.class.getClassLoader(), new Class[]{MyInterface.class});
        Constructor constructor =myProxy.getConstructor(new Class[]{InvocationHandler.class});
        MyInterface m = (MyInterface)constructor.newInstance(myInvotion);
        m.sayHello();
    }
}

//定义了一个调用处理器
class MyInvotion implements InvocationHandler {

    private Object realObj;

    public MyInvotion(Object obj){
        this.realObj =  obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        //通过代理执行原对象的方法
        System.out.println("invoking before");
        return method.invoke(realObj,args);
    }
}

//定义一个接口
 interface MyInterface {

    public void sayHello();
}

//该接口的一个实现类，该类就是我们的原对象
 class ClassA implements MyInterface {

    public void sayHello(){
        System.out.println("hello walker");
    }
}
