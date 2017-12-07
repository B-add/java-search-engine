package provider;

/**
 * Created by val on 07/12/17.
 */
public interface Provider<T> {
    T getInstance();
    Class getProviderClass();
}
