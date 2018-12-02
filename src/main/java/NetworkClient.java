import java.rmi.UnexpectedException;

public interface NetworkClient {

    String callRemoteSynchronously() throws UnexpectedException;
}
