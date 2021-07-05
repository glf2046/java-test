package com.lefeng.ctor;

/**
 * @author guff
 * @since 2020-01-14 02:30
 */
public class WaysOfCtor {

    private String f1 = "hello";
//
//    private WaysOfCtor(){
//
//    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public static class Student{
        private String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class MaleStudent extends Student{

        private String something;

        public MaleStudent(String thatThing) {
            this("default name", 0, thatThing);
        }

        public MaleStudent(String name, int age, String thatThing){
            super(name, age);
            this.something = thatThing;
        }

        public String getSomething() {
            return something;
        }

        public void setSomething(String something) {
            this.something = something;
        }
    }


}
