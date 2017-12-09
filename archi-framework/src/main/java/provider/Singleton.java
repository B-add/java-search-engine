package provider;

import aspect.DynamicProxyHandler;

import java.lang.reflect.Proxy;

/**
 * Created by val on 07/12/17.
 */
public class Singleton<T> extends AnyProvider<T> {

    private final T instance;
    private final Class<? super T> providerClass;

    public Singleton(Class<? super T> c, T instance) {
        super();
        this.providerClass = c;
        this.instance = instance;
    }

    public T getProviderInstance() {
        return setProxy(instance);
    }

    public Class<? super T> getProviderClass() {
        return providerClass;
    }
}
