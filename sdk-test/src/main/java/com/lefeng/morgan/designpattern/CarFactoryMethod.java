package com.lefeng.morgan.designpattern;

public class CarFactoryMethod {
    public static void main(String[] args) {
        CarFactory carFactory = new BMWFactory();
        Car car = carFactory.createCar();
        car.drive();
    }

    interface Car{
        void drive();
    }

    static class BMW implements Car {
        @Override
        public void drive() {
            System.out.println("driving BMW");
        }
    }

    static class Audi implements Car {
        @Override
        public void drive() {
            System.out.println("driving Audi");
        }
    }

    interface CarFactory{
        Car createCar();
    }

    static class BMWFactory implements CarFactory{

        @Override
        public Car createCar() {
            return new BMW();
        }
    }

    static class AudiFactory implements CarFactory{

        @Override
        public Car createCar() {
            return new Audi();
        }
    }
}
