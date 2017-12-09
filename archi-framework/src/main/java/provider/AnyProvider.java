package provider;

import aspect.DynamicProxyHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by val on 09/12/17.
 */
public abstract class AnyProvider<T> implements Provider<T> {
    protected final T setProxy(T instance) {
        return (T) Proxy.newProxyInstance(getProviderClass().getClassLoader(),
                new Class[] { getProviderClass() },
                new DynamicProxyHandler(instance));
    }
}
