package methodReference;

public class MethodReferenceNew {

    public static void main(String[] args) {
        MyInterface ref = Hello::new;
        ref.display("hello");
    }

    @FunctionalInterface
    interface MyInterface{
        Hello display(String msg);
    }

    static class Hello{
        public Hello(String msg){
            System.out.println(msg);
        }
    }

}
