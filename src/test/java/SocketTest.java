import br.com.nyexgaming.sdk.NyexWS;
import br.com.nyexgaming.sdk.clients.ws.WebSocketHandler;

public class SocketTest extends WebSocketHandler {

    public static void main(String[] args) {
        NyexWS nyex = new NyexWS("6dfddb89-e14a-4ae8-a3b1-d7da276f9122", "f2a31f7a-72c4-4d12-b87d-669d0836ae38");

        nyex.addHandler(new WebSocketHandler() {
            @Override
            public void handleError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
