import java.rmi.UnexpectedException;
import java.util.Random;

public class UnstableNetworkClient implements NetworkClient{
    @Override
    public String callRemoteSynchronously() throws UnexpectedException {
        Random random = new Random();
        int successProbability = random.nextInt(3);

        if (successProbability == 0 || successProbability == 1) {
            return "{\n" +
                    "  \"status\": \"success\"\n" +
                    "}";
        }
        throw new UnexpectedException("couldn't resolve dns name");
    }
}
