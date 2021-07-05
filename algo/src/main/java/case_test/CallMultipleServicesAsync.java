package case_test;

import java.util.concurrent.*;

public class CallMultipleServicesAsync {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Response> myBlockingQueue = new ArrayBlockingQueue<>(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        executor.execute(() -> {
            try {
                myBlockingQueue.add(service1());
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                myBlockingQueue.add(service2());
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                myBlockingQueue.add(service3());
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        countDownLatch.await();

        int sum = myBlockingQueue.parallelStream().map(Response::getValue).reduce(0, Integer::sum);
        //need to wait 1+2+3 seconds
        System.out.println(sum);
        executor.shutdownNow();
    }

    static class Response{
        public Response(int status, int value) {
            this.status = status;
            this.value = value;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        int status;
        int value;
    }


    static Response service1() throws InterruptedException {
        Thread.sleep(1000);
        return new Response(1,1);
    }

    static Response service2() throws InterruptedException {
        Thread.sleep(2000);
        return new Response(1,1);
    }

    static Response service3() throws InterruptedException {
        Thread.sleep(3000);
        return new Response(1,1);
    }
}
