package defaultMethod;

/**
 * @author guff
 * @since 2019-06-7:54 PM
 */
public class Example implements MyInterface {

    public void existingMethod(String str){
        System.out.println("String is: "+str);
    }

    @Override
    public void newDefaultMethod() {
        System.out.println("Overridden - Newly added default method - 1");
    }
}
