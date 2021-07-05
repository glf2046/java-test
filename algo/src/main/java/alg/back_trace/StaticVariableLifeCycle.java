package alg.back_trace;

public class StaticVariableLifeCycle {
    public static void main(String[] args) throws InterruptedException {
        Beta b1 = new Beta("b1");
        Beta b2 = new Beta("b2");
        Alpha a1 = new Alpha();
        Alpha a2 = new Alpha();

        System.out.println("Alpha.b1: " + Alpha.b1);
        System.out.println("a1.b2: " + a1.b2);

        a1.b1 = b1;
        a1.b2 = b1;
        System.out.println("a1.b2: " + a1.b2);
        a2.b2 = b2;
        
        a1 = null;
        b1 = null;
        b2 = null;
        System.out.println("b1: " + b1);
        System.out.println("b2: " + a2.b2);

        System.out.println("Alpha.b1: " + Alpha.b1);

        Thread.sleep(20000);

        System.gc();

        Thread.sleep(10000);

        System.out.println("b2: " + a2.b2);
        System.out.println("Alpha.b1: " + Alpha.b1);

        Thread.sleep(1000000);


    }
}
