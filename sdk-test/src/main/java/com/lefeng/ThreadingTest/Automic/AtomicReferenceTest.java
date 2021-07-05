package com.lefeng.ThreadingTest.Automic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    static AtomicReference<User> atomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user1 = new User("name1", 12);
        atomicReference.set(user1);
        User updateUser = new User("name2", 13);
        atomicReference.compareAndSet(user1, updateUser);

        System.out.println(atomicReference.get().toString());
    }
}
