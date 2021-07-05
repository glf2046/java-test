package com.lefeng.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author guff
 * @since 2020-08-13 13:40
 */
public class TimerException {
    public static void main(String[] args) {

        Timer timer = new Timer();

        for (int i = 0; i < 5; i++) {
            final int j = i;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(j+ " timer task, threadId: " + Thread.currentThread().getId());
                    if (j == 3){
                        throw new RuntimeException(j + " timer exception");
                    }

                    String temp = new String("hello" + "world");
                    for (int k = 0; k < 1000000000; k++) {
                        int index = temp.indexOf("e");
                        if (index == 0) {
                            System.out.println("0000");
                        }
                    }

                    System.out.println(j + " timer finished");
                }
            }, new Date(100));

            System.out.println(j + " timer scheduled");
        }

    }
}
