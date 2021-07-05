package oom;

import java.util.ArrayList;
import java.util.List;

public class ThreadCreation {

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        while(true){
            Thread t = new Thread(() -> System.out.println("he"));

            threadList.add(t);
        }
    }
}
