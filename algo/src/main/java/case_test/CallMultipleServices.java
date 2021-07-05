package case_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collector;

public class CallMultipleServices {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        List<Response> responses = new ArrayList<>();
        responses.add(service1());
        responses.add(service2());
        responses.add(service3());

        int sum = responses.parallelStream().map(Response::getValue).reduce(0, Integer::sum);
        //need to wait 1+2+3 seconds
        System.out.println(sum);
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
