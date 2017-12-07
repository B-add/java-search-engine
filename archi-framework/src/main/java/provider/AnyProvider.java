package provider;

/**
 * Created by val on 07/12/17.
 */
public class AnyProvider<T> implements Provider<T> {

    private T instance;
    private Class<? super T> providerClass;

    public AnyProvider(Class<? super T> c, T instance) {
        this.providerClass = c;
        this.instance = instance;
    }

    public T getInstance() {
        return instance;
    }

    public Class getProviderClass() {
        return providerClass;
    }
}