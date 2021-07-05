package com.lefeng.CollectionTest.elementOrder;

import java.util.Objects;

public class MyKey {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyKey)) return false;
        MyKey myKey = (MyKey) o;
        return number == myKey.number &&
                Objects.equals(value, myKey.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MyKey{" +
                "number=" + number +
                ", value='" + value + '\'' +
                '}';
    }

    public MyKey(int number, String value) {
        this.number = number;
        this.value = value;
    }

    private int number;
    private String value;

    public int getNumber() {
        {
            String s11 = "hello";
            System.out.println(s11);
            ;
        }
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
