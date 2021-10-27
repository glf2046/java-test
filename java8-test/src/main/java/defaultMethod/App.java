package defaultMethod;

/**
 * @author guff
 * @since 2019-06-7:55 PM
 */
public class App {
    
    public static void main(String[] args) {
        Example example = new Example();
        example.newDefaultMethod();
        example.existingMethod("hello");
        MyInterface.staticMethod1();
        System.out.println(MyInterface.KEY);;
        System.out.println("#########");

        Example2 obj = new Example2();

        //calling the default method of interface
        obj.newDefaultMethod();
        //calling the abstract method of interface
        obj.existingMethod("Java 8 is easy to learn");

        MyInterface.staticMethod1();
    }
}
