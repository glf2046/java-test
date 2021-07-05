package com.lefeng.threading.escape;

import java.util.Date;

public class ThisEscape {
    public static void main(String[] args) throws InterruptedException {
        ThisEscape thisEscape = new ThisEscape(new EventSource());
    }
    private final int num;

    public ThisEscape(EventSource source) throws InterruptedException {
      new Thread(new Runnable() {
          @Override
          public void run() {
              source.registerListener(new EventListener() {
                  public void onEvent(Object o) {
                      doSomething(o);
                  }
              });
              source.signal();
          }
      }).start();
      
      //只要是这种注册回调的函数有用到当前类成员函数的情况，都会产生this逃逸，这里只是故意停顿一下，让前面的线程先执行
      Thread.sleep(100);
        num = 42;
    }

    private void doSomething(Object o) {
        if (num != 42) {
            System.out.println("Race condition detected at " + new Date());
        }
    }
}
