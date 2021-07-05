package case_test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue<>(10);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        System.out.println("putting item: " + i);
                        myBlockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        System.out.println("getting item: " + myBlockingQueue.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2.start();

//        t1.interrupt();

        t1.join();
        t2.join();

        System.out.println("done");

    }

    private Object[] items;
    private ReentrantLock lock;
    private Condition notEmpty;
    private Condition notFull;
    private int size;

    public MyBlockingQueue(int capacity) {
        items = new Object[capacity];
        lock = new ReentrantLock(true);
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public void put(E e) throws InterruptedException {
        //lock动作要放到try的外面，因为可能获得不到锁，如果没获得，那么在finally中调用lock.unlock()的时候就会报错：IllegalMonitorStateException.
        lock.lockInterruptibly();
//      lock.lock();
        while (size == items.length) {
            System.out.println("await put...");
            notFull.await();
        }
        try {
            items[size++] = e;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public E get() throws InterruptedException {

        lock.lockInterruptibly();
//      lock.lock();
        while (size == 0) {
            System.out.println("await get...");
            notEmpty.await();
        }
        try {
            E x = (E) items[--size];
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
