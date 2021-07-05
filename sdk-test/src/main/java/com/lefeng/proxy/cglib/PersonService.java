package com.lefeng.proxy.cglib;

public class PersonService {
    public String sayHello(String name) {
        return "Hello " + name;
    }

    public String sayHello2(String name) {
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}

class PersonServiceA extends PersonService{
    @Override
    public String sayHello(String name) {
        return super.sayHello(name);
    }

}
