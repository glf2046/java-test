package alg.back_trace;

public class A {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print("1");
            synchronized (args) {
                System.out.print("2");
                try{
                    args.wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.print("3");
        }
    }
}
