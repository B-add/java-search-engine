package aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by val on 09/12/17.
 */
public class DynamicProxyHandler<T> implements InvocationHandler {
    private final T original;
    private final HashMap<String, ArrayList<Aspect>> beforeAspects;
    private final HashMap<String, ArrayList<Aspect>> afterAspects;

    public DynamicProxyHandler(T original, HashMap<String, ArrayList<Aspect>> beforeAspects,
                               HashMap<String, ArrayList<Aspect>> afterAspects) {
        this.original = original;
        this.beforeAspects = beforeAspects;
        this.afterAspects = afterAspects;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        callMatchingAspectsFuncs(beforeAspects, method.getName());
        Object res = method.invoke(original, args);
        callMatchingAspectsFuncs(afterAspects, method.getName());
        return res;
    }

    private void callMatchingAspectsFuncs(HashMap<String, ArrayList<Aspect>> aspects, String methodName) {
        for (Aspect afterAspect : aspects.get(methodName)) {
            try {
                afterAspect.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
