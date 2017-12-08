package provider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by val on 08/12/17.
 */
public class Prototype<T> implements Provider<T> {
    private final Class<? super T> c;
    private Constructor<T> constructor;
    private Object[] params;

    public Prototype(Class<? super T> c, Class<T> instanceClass, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Integer length = params != null ? params.length : 0;
        Class[] paramsTypes = new Class[length];
        for (int i = 0; i < length; i++) {
            paramsTypes[i] = params[i].getClass();
        }
        this.constructor = instanceClass.getConstructor(paramsTypes);
        this.c = c;
        this.params = params;
    }

    public T getProviderInstance() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return constructor.newInstance(params);
    }

    public Class getProviderClass() {
        return c;
    }
}
