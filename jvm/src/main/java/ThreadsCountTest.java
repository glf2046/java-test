import java.util.ArrayList;
import java.util.List;

/**
 * @author guff
 * @since 2020-04-13 04:14
 */
public class ThreadsCountTest {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<Thread>();
        //物理内存耗完了，很容易死机
        for (int i = 0; i < 60000; i++) {
            list.add(new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        int startedCount = 0;
        for (final Thread thread : list) {
            thread.start();
            startedCount++;
            System.out.println(startedCount);
        }

        Thread.currentThread().join();
    }
}
