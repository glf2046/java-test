package oom;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    //jvm options: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/guff/dumps

    private static final int MEGABYTE = (1024*1024);

    public static void main(String[] args) throws InterruptedException {

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();

        long maxMemory = heapUsage.getMax() / MEGABYTE;
        long usedMemory = heapUsage.getUsed() / MEGABYTE;
        System.out.println(" : Memory Use :" + usedMemory + "M/" + maxMemory + "M");

        try {
                List<String> list = new ArrayList<>(10);
                while (true) {
                    list.add("1");
                }
        } catch (OutOfMemoryError e) {
            System.out.println("oom caught");
        } finally {
            System.out.println("oom finally");
        }
    }
}
