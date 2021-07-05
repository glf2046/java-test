import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author guff
 * @since 2020-01-31 17:50
 */
public class WeakReferenceGCTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().maxMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().totalMemory()/(1024*1024));



        System.out.println("##############");
        System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().maxMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().totalMemory()/(1024*1024));

        System.gc();

        System.out.println("##############");
        System.out.println(Runtime.getRuntime().freeMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().maxMemory()/(1024*1024));
        System.out.println(Runtime.getRuntime().totalMemory()/(1024*1024));

    }

    static class A{

        private byte[] bytes;

        A(byte[] bytes) {
            this.bytes = bytes;
        }
    }
}
