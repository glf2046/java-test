package CompletableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author guff
 * @since 2020-02-10 06:51
 * https://colobu.com/2016/02/29/Java-CompletableFuture/
 * https://www.baeldung.com/java-completablefuture
 */
public class Main {
    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();
    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
        return rand.nextInt(1000);
    }
    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Main::getMoreData);
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println("value: " + v);
            System.out.println(e);
        });
        //need either of following two method calls in place to block the main thread's exit before above future returns
        System.out.println(f.get());
        System.in.read();
    }
}
