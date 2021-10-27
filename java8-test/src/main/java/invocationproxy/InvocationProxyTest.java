package invocationproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InvocationProxyTest {
    public static void main(String[] args) {


    }

//    public static MethodInterpreter caching(MethodInterpreter interpreter) {
//        ConcurrentMap<Method, MethodCallHandler> cache = new ConcurrentHashMap<>();
//        return cache.computeIfAbsent(method, interpreter::interpret);
//    }

    @FunctionalInterface
    public interface MethodCallHandler {
        Object invoke(Object proxy, Object[] args) throws Throwable;
    }

    public interface MethodInterpreter extends InvocationHandler {

        @Override
        default Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            MethodCallHandler handler = interpret(method);
            return handler.invoke(proxy, args);
        }

        MethodCallHandler interpret(Method method);
    }
}
