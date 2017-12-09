package aspect;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * Created by val on 08/12/17.
 */
public class Aspect implements Callable {
    private final Method method;
    private final Callable func;

    public Aspect(Method method, Callable func) {
        this.method = method;
        this.func = func;
    }

    @Override
    public Object call() throws Exception {
        return func.call();
    }

    public Method getMethod() {
        return method;
    }
}
