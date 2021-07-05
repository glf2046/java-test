/**
 * @author guff
 * @since 2020-02-17 06:45
 */
public class PrintStackTraceOOM {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
           new Thread(new Runnable() {
               public void run() {
                   StringBuilder s = new StringBuilder();
                   for (int j = 0; j < Integer.MAX_VALUE; j++) {
                       s.append(j);
                   }

                   try {
                       Thread.sleep(10000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }).start();
        }
    }
}
