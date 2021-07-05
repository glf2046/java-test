import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author guff
 * @since 2020-01-31 17:50
 */
public class JVisualVMGCTest {
    private byte[] bytes = new byte[1024 * 100];
    public static void main(String[] args) throws InterruptedException {
        ArrayList<JVisualVMGCTest> jVisualVMGCTests = new ArrayList<JVisualVMGCTest>();
        while (true) {
            jVisualVMGCTests.add(new JVisualVMGCTest());
            Thread.sleep(5);
        }
    }
}
