package com.lefeng.proxy.dynamic.invocationproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//https://www.ibm.com/developerworks/library/j-jtp08305/index.html#listing2
public class InvocationProxyTest implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("---正在执行的方法：" + method);
        if (args != null) {
            System.out.println("下面是执行该方法时传入的实参为：");
            for (Object val : args) {
                System.out.println(val);
            }
        } else System.out.println("该方法没有实参");
        Object o = method.invoke(target, args);
        System.out.println("执行完毕：" + method);

        return o;
    }

    public static void main(String[] args) {
        SomePerson somePerson = new SomePerson();
        Person personProxy =(Person)ProxyFactory.getProxy(somePerson);
        personProxy.walk();
        personProxy.sayHello("孙悟空");


        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        ProxyUtils.generateClassFile(personProxy.getClass(), "PersonProxy");
        personProxy.equals(new SomePerson());
        personProxy.hashCode();
    }
}

class ProxyFactory{
    public static Object getProxy(Object target){
        InvocationProxyTest handler = new InvocationProxyTest();
        handler.setTarget(target);
        //注意这里的Person是一个接口interface。
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}

class SomePerson implements Person{

    @Override
    public void walk() {
        System.out.println("someperson walk");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("someperson sayHello: " + name);
    }
}

interface Person {

    void walk();

    void sayHello(String name);
}
