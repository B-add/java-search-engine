package provider;

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
        return instance;
    }

    public Class<? super T> getProviderClass() {
        return providerClass;
    }
}
