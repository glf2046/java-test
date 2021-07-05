package com.lefeng.CollectionTest.hashmap;

public class HashcodeTest {

    public static void main(String[] args) {
        HashcodeTest test = new HashcodeTest();
        System.out.println(test.hashCode());;
        System.out.println(System.identityHashCode(test));;

        test.setNum(10);
        System.out.println(test.hashCode());
        System.out.println(System.identityHashCode(test));;

    }

    private int num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashcodeTest)) return false;
        HashcodeTest that = (HashcodeTest) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
