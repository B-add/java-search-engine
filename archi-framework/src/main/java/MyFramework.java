import provider.Provider;
import scope.Scope;

import java.util.Stack;

/**
 * Created by val on 07/12/17.
 */
public class MyFramework {
    private Stack<Scope> scopes;

    public Provider getProviderInstance(Class c) {
        Provider res = null;
        for (int i = scopes.size() - 1; i >= 0; i--) {
            res = scopes.get(i).getProvider(c);
            if (res != null) {
                return res;
            }

        }
        return null;
    }
    public Provider getProvider(Class c) {
        Provider res = null;
        for (int i = scopes.size() - 1; i >= 0; i--) {
            res = scopes.get(i).getProvider(c);
            if (res != null) {
                return res;
            }

        }
        return null;
    }
}
