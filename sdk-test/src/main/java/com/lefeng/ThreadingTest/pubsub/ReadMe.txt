https://blog.csdn.net/worldchinalee/article/details/83790790

为啥wait需要在while中，一般是：
while (condition does not hold) {
    obj.wait();
}

在多线程环境下，当另外一个线程调用obj.notify或者notifyAll唤醒这个等待线程时（假设最终实际被唤醒获得锁的是这个线程），有两种情况：
1. 唤醒线程认为条件满足了（condition does hold)，可以去叫醒这个等待线程，比如一个producer去唤醒所有consumer和其它的producer，这时候如果最终唤醒的是consumer，没问题，因为pub之后可以sub，
    数组也不越界。
2. 唤醒线程唤醒了不该唤醒的线程，比如consumer消费完最后一个消息，这时候数组长度为0，但是尝试notifyAll的时候，却实际上唤醒了另一个consumer，这时候数组已经空了，没办法继续消费，
    如果继续访问数组，会发生越界问题。

所以在这种情况下，所有consumer在wait的时候，外层需要while循环来判断条件是否还是不成立，如果不成立继续等待。

如果用的是if，那么当被notifyAll之后，就就直接执行了。

总结：多线程环境，wait条件可能随时被别的线程改动，所以退出wait的时候，需要再次检查条件是否还是不成立，这时候就可以用while来包住wait了。