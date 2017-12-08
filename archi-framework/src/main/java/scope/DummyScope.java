package scope;

import com.sun.org.apache.xpath.internal.operations.Bool;
import provider.Provider;

import java.util.Stack;

/**
 * Created by val on 07/12/17.
 */
public class DummyScope implements Scope {
    public final Stack<Provider> providers = new Stack<Provider>();

    public boolean registerProvider(Provider p) {
        if (p == null) {
            return false;
        }
        providers.push(p);
        return true;
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
