package provider;

import aspect.DynamicProxyHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by val on 08/12/17.
 */
public class Prototype<T> extends AnyProvider<T> {
    private final Class<? super T> providerClass;
    private final Constructor<T> constructor;
    private final Object[] params;

    public Prototype(Class<? super T> c, Class<T> instanceClass, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        super();
        Integer length = params != null ? params.length : 0;
        Class[] paramsTypes = new Class[length];
        for (int i = 0; i < length; i++) {
            paramsTypes[i] = params[i].getClass();
        }
        this.constructor = instanceClass.getConstructor(paramsTypes);
        this.providerClass = c;
        this.params = params;
    }

    public T getProviderInstance() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return setProxy(constructor.newInstance(params));
    }

    public Class getProviderClass() {
        return providerClass;
    }
}
