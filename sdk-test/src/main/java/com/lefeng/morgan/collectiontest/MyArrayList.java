package com.lefeng.morgan.collectiontest;

import java.util.List;

public class MyArrayList<E> implements MyList<E> {

    //The reason ArrayList's underlying data item type is 'Object' is that you can't create an array using generic type like following.
    //Instead we have to use :     private Object[] elementsData = new Object[]{};
    //private E[] elementsData = new E[]{};

    @Override
    public void add(E item) {

    }

    @Override
    public void remove(E item) {

    }

    @Override
    public void set(int index, E item) {

    }

    @Override
    public void size() {

    }

    @Override
    public boolean contains(E item) {
        return false;
    }
}
