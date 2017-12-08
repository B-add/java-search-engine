import provider.Provider;
import scope.DummyScope;
import scope.Scope;

import java.util.Stack;

/**
 * Created by val on 07/12/17.
 */
public class MyFramework {
    private final Stack<Scope> scopes = new Stack<Scope>();

    public MyFramework() {
        scopes.push(new DummyScope());
    }

    public Object getProviderInstance(Class c) {
        Provider matchnigProvider;
        for (int i = scopes.size() - 1; i >= 0; i--) {
            matchnigProvider = scopes.get(i).getProvider(c);
            if (matchnigProvider != null) {
                return matchnigProvider.getProviderInstance();
            }

        }
        return null;
    }

    public void addProvider(Provider p) {
        scopes.peek().registerProvider(p);
    }

    public void enterScope(Scope s) {
        scopes.push(s);
    }

    public void leaveScope() {
        scopes.pop();
    }
}
