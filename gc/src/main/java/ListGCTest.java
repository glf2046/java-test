import java.util.ArrayList;
import java.util.List;

/**
 * @author guff
 * @since 2020-01-31 17:50
 */
public class ListGCTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().maxMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().totalMemory()/(1024*1024));
        List<A> list = new ArrayList<A>();
        for (int i = 0; i < 100; i++) {
            list.add(new A(new byte[1024*1024]));
        }

        System.out.println("##############");
        System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().maxMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().totalMemory()/(1024*1024));

        list.clear();
        System.gc();

        System.out.println("##############");
        System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().maxMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().totalMemory()/(1024*1024));

        Thread.currentThread().join();
    }

    static class A{

        private byte[] bytes;

        A(byte[] bytes) {
            this.bytes = bytes;
        }
    }
}
