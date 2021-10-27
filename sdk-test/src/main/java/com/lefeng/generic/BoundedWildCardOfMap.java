package com.lefeng.generic;

import java.util.HashMap;
import java.util.Map;

public class BoundedWildCardOfMap {
    public static void addRegistry(Map<String, ? extends Person> registry) {
    }

    public static void main(String[] args) {
        Map<String, Driver> driverMap = new HashMap<>();
        addRegistry(driverMap);
    }


    private static class Person {
    }

    private static class Driver extends Person {

    }
}


