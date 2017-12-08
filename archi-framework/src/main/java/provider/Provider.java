package provider;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by val on 07/12/17.
 */
public interface Provider<T> {
    T getProviderInstance() throws IllegalAccessException, InvocationTargetException, InstantiationException;
    Class getProviderClass();
}
