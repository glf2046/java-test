package functionalInterface;

//https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
@FunctionalInterface
interface MyFunctionalInterface {

    int addMethod(int a, int b);
}
public class test1 {

    public static void main(String args[]) {
        // lambda expression
        MyFunctionalInterface sum = (a, b) -> a + b;
        System.out.println("Result: "+sum.addMethod(12, 100));

    }

}
