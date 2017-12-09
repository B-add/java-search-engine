package provider;

import aspect.Aspect;
import aspect.DynamicProxyHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by val on 09/12/17.
 */
public abstract class AnyProvider<T> implements Provider<T> {
    private final HashMap<String, ArrayList<Aspect>> beforeAspects;
    private final HashMap<String, ArrayList<Aspect>> afterAspects;

    protected AnyProvider() {
        beforeAspects = new HashMap<>();
        afterAspects = new HashMap<>();
    }

    protected final T setProxy(T instance) {
        return (T) Proxy.newProxyInstance(getProviderClass().getClassLoader(),
                new Class[] { getProviderClass() },
                new DynamicProxyHandler(instance, beforeAspects, afterAspects));
    }

    public void before(Method method, Callable func) {
        addAspect(method, func, beforeAspects);
    }

    public void after(Method method, Callable func) {
        addAspect(method, func, afterAspects);
    }

    private void addAspect(Method method, Callable func, HashMap<String, ArrayList<Aspect>> aspects) {
        ArrayList<Aspect> funcs = aspects.containsKey(method.getName()) ? new ArrayList<>() : aspects.get(method.getName());
        funcs.add(new Aspect(method, func));
        aspects.put(method.getName(), funcs);
    }
}
