/**
 * @author guff
 * @since 2020-02-07 21:51
 */
public class LongGCTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        System.out.println((Integer.MAX_VALUE)/(1024*1024/8));

        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum = new Long(i);
        }

        long end = System.currentTimeMillis();

        System.out.println("time spent: " + (end - start) /1000);
    }
}
