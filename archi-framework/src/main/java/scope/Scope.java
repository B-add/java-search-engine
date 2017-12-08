package scope;

import provider.Provider;

/**
 * Created by val on 07/12/17.
 */
public interface Scope {
    boolean registerProvider(Provider p);
    Provider getProvider(Class c);
}
