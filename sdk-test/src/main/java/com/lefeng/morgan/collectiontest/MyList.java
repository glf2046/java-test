package com.lefeng.morgan.collectiontest;

public interface MyList<E> {

    void add(E item);

    void remove(E item);

    void set(int index, E item);

    void size();

    boolean contains(E item);
}
