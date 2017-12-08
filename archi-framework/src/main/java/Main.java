import provider.Singleton;
import scope.DummyScope;
import toto.Blob;
import toto.Blob1;
import toto.Blob2;

/**
 * Created by val on 08/12/17.
 */
public class Main {
    public static void main(final String[] args) {
        MyFramework framework = new MyFramework();

        framework.addProvider(new Singleton(Blob.class, new Blob1()));

        Blob blob = (Blob) framework.getProviderInstance(Blob.class);

        System.out.println(blob.getBlob());

        framework.enterScope(new DummyScope());

        framework.addProvider(new Singleton(Blob.class, new Blob2()));

        blob = (Blob) framework.getProviderInstance(Blob.class);

        System.out.println(blob.getBlob());

        framework.leaveScope();

        blob = (Blob) framework.getProviderInstance(Blob.class);

        System.out.println(blob.getBlob());
    }
}
