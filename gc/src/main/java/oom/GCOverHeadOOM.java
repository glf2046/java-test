package oom;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GCOverHeadOOM {
    //JVM args: -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/guff/dumps
    public static void main(String[] args) throws Exception {
        List<Object> list = new LinkedList<>();
        int i = 0;
        while (true) {
            i++;
            if (0 == i % 1000) {
                TimeUnit.MILLISECONDS.sleep(10);
            }
            list.add(new Object());
        }
    }
}
