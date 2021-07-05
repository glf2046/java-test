package com.lefeng;

import java.io.IOException;

public class CallStackOfInnerClass {
    public static void main(String[] args) {
        int count = 0;

        try {
            new CallStackOfInnerClass().do1(++count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void do1(int count) throws Exception {
        System.out.println("do1 " + count);
        try {
            do2(++count);
        } catch (Exception e) {
            throw new Exception("Exception from do2", e);
        }
    }

    private void do2(int count) {
        System.out.println("do2 " + count);
        try {
            do3(++count);
        } catch (IOException e) {
            throw new RuntimeException("RuntimeException from do2", e);
        }
    }

    private void do3(int count) throws IOException {
        System.out.println("do3 "  + count);

        try {
            do4(++count);
        } catch (ConnectionClosedException e) {
            throw new IOException("IOException from do3", e);
        }
    }

    private void do4(final int count) throws ConnectionClosedException {
        System.out.println("do4 " + count);
        new A() {
            @Override
            public void a() {
                throw new ConnectionClosedException("connection exception from do4 " + count);
            }
        }.a();

        new B("hello").doB();
        //throw new ConnectionClosedException("connection exception from do4 " + count);
    }

    private static class ConnectionClosedException extends RuntimeException {
        private static final long serialVersionUID = 7875660948116280401L;
        String message;
        public ConnectionClosedException(String s) {
            message = s;
        }
    }

    interface A{
        void a();
    }

    class B{
       private String message;

        public B(String message) {
            this.message = message;
        }

        public void doB() {
            System.out.println("doB");
            throw new ConnectionClosedException("connection exception from doB ");
        }
    }
}
