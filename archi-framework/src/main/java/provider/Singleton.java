package provider;

import aspect.DynamicProxyHandler;

import java.lang.reflect.Proxy;

/**
 * Created by val on 07/12/17.
 */
public class Singleton<T> implements Provider<T> {

    private final T instance;
    private final Class<? super T> providerClass;

    public Singleton(Class<? super T> c, T instance) {
        this.providerClass = c;
        this.instance = instance;
    }

    public T getProviderInstance() {
        DynamicProxyHandler<T> dynamicProxy = new DynamicProxyHandler(instance);
        return (T) Proxy.newProxyInstance(providerClass.getClassLoader(),
                new Class[] { providerClass },
                dynamicProxy);
    }

    public Class<? super T> getProviderClass() {
        return providerClass;
    }
}
