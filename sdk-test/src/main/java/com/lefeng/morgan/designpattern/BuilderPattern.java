package com.lefeng.morgan.designpattern;

public class BuilderPattern {

    protected String name;

    private int age;

    private String address;

    private double price;

    public BuilderPattern(BuilderPatternBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.price = builder.price;
    }

    static class BuilderPatternBuilder{

        //Mandatory field
        protected String name;

        //Optional fields
        private int age;
        private String address;
        private double price;

        public BuilderPatternBuilder(String name) {
            this.name = name;
        }

        public BuilderPatternBuilder age(int age){
            this.age = age;
            return this;
        }
        
        public BuilderPatternBuilder address(String add){
            address = add;
            return this;
        }

        public BuilderPatternBuilder price(double price){
            this.price = price;
            return this;
        }

        public BuilderPattern build(){
            BuilderPattern pattern = new BuilderPattern(this);
            return pattern;
        }
    }

    public static void main(String[] args) {
        BuilderPatternBuilder builder = new BuilderPatternBuilder("name1");
        BuilderPattern pattern = builder.age(10).address("888#").build();

        System.out.println(pattern.name);
        System.out.println(pattern.age);
        System.out.println(pattern.address);
        System.out.println(pattern.price);

    }
}
