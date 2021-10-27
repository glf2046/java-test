package StaticClassInit;

public class Singleton {

    static class SingletonHolder{
        public SingletonHolder() {
            System.out.println("SingletonHolder ctor");
        }

        static Singleton Instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.Instance;
    }
}
