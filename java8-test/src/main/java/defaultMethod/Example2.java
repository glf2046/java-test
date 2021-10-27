package defaultMethod;

/**
 * @author guff
 * @since 2019-06-7:54 PM
 */
public class Example2 implements MyInterface {

    public void existingMethod(String str){
        System.out.println("String is: "+str);
    }

    @Override
    public void newDefaultMethod2() {
        System.out.println("Overridden - newDefaultMethod2");
    }
}
