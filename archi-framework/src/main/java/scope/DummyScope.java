package scope;

import provider.Provider;

import java.util.Stack;

/**
 * Created by val on 07/12/17.
 */
public class DummyScope implements Scope {
    public final Stack<Provider> providers = new Stack<Provider>();

    public void addProvider(Provider p) {
        providers.push(p);
    }

    public Provider getProvider(Class c) {
        for (int i = providers.size() - 1; i >= 0; i--) {
            if (providers.get(i).getProviderClass().equals(c)) {
                return providers.get(i);
            }
        }
        return null;
    }
}
