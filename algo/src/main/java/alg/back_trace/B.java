package alg.back_trace;

public class B extends Thread {
    public B(Runnable target) {
        super(target);
    }

    static ThreadLocal<String> treadLocal;

    public static void main(String[] args) {
        treadLocal.set("a");
        int i = 0;
        int j = i;
        System.out.println(j);
        B b = new B(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        });
        b.run();;
    }

    @Override
    public void start(){
        for (int i = 0; i < 10; i++) {
            System.out.println("aa");
        }
    }
}
