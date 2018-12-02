import java.util.Objects;
import java.util.stream.IntStream;

public class Main {

    public static final String STATUS_CONNECTION_UNSUCCESSFULL = "{\"status\":\"connection unsuccessfull\"}";

    public static void main(String... args) {

        //method should be called max 3times
        NetworkClient client = new UnstableNetworkClient();


        String answer = IntStream.range(0, 3)
                .peek(value -> System.out.println(String.format("Try: %d", value)))
                .mapToObj(value -> {
                    try {
                        return client.callRemoteSynchronously();
                    } catch (Exception e) {
                        System.out.println(String.format("Try unsuccessfull: %d", value));
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(STATUS_CONNECTION_UNSUCCESSFULL);


        System.out.println(answer);
    }
}
