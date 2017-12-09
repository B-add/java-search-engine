package aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by val on 09/12/17.
 */
public class DynamicProxyHandler<T> implements InvocationHandler {
    private final T original;

    public DynamicProxyHandler(T original) {
        this.original = original;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("BEFORE");
        Object res = method.invoke(original, args);
        System.out.println("AFTER");
        return res;
    }
}
