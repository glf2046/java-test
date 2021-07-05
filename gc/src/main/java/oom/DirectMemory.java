package oom;

import java.nio.ByteBuffer;

//jVM args: -verbose:gc -Xms10M -Xmx10M -XX:MaxDirectMemorySize=5M -Xss128k -XX:+PrintGCDetails
public class DirectMemory {
    private static final int ONE_MB = 1024 * 1024 * 1024;
    private static int count = 1;

    public static void main(String[] args) {
        try {
            while (true) {
                ByteBuffer buffer = ByteBuffer.allocateDirect(ONE_MB);
                count++;
            }
        } catch (Exception e) {
            System.out.println("exception occur,instance count : " + count);
            e.printStackTrace();
        }

    }
}
