package defaultMethod;

/**
 * @author guff
 * @since 2019-06-7:54 PM
 */
public interface MyInterface {
    /* This is a default method so we need not
     * to implement this method in the implementation
     * classes
     */
    default void newDefaultMethod(){
//        System.out.println("newDefaultMethod");
        newDefaultMethod2();
    }

    default void newDefaultMethod2(){
        
    }

    static void staticMethod1(){
        System.out.println("static method - 1");
    }

    String KEY = "key";

    /* Already existing public and abstract method
     * We must need to implement this method in
     * implementation classes.
     */
    void existingMethod(String str);
}
