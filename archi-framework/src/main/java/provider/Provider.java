package provider;

import aspect.Aspect;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by val on 07/12/17.
 */
public interface Provider<T> {
    T getProviderInstance() throws IllegalAccessException, InvocationTargetException, InstantiationException;
    Class getProviderClass();
}
