package com.lefeng.morgan.designpattern;

public class CarSimpleFactory {

    public static void main(String[] args) {
        Car car = CarSimpleFactory.createCar("BMW");
        car.drive();
    }

    public static Car createCar(String name){
        switch (name){
            case "BMW" :
                return new BMW();
            case "Audi" :
                return new Audi();
            default:
                return null;
        }
    }

    interface Car{
        void drive();
    }

    static class BMW implements Car{
        @Override
        public void drive() {
            System.out.println("driving BMW");
        }
    }

    static class Audi implements Car{
        @Override
        public void drive() {
            System.out.println("driving Audi");
        }
    }
}


