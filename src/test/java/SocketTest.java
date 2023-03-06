import br.com.nyexgaming.sdk.NyexWS;
import br.com.nyexgaming.sdk.clients.ws.WebSocketHandler;
import br.com.nyexgaming.sdk.errors.NetworkErrorException;
import br.com.nyexgaming.sdk.errors.RequestFailedException;

public class SocketTest extends WebSocketHandler {

    public static void main(String[] args) throws InterruptedException, NetworkErrorException, RequestFailedException {
        NyexWS nyex = new NyexWS("6dfddb89-e14a-4ae8-a3b1-d7da276f9122", "f2a31f7a-72c4-4d12-b87d-669d0836ae38");

        nyex.connect(NyexWS.Game.MINECRAFT);

        /*nyex.handlers().add(new NyexWS.NyexHandler() {
            @Override
            public void handleCategories(Category[] categories) {
                System.out.println(categories.length + " categorias recebidas!");
            }

            @Override
            public void handleProducts(Product[] purchases) {
                System.out.println(purchases.length + " produtos recebidos!");
            }

            @Override
            public void handleTransactions(Purchase[] purchases) {
                System.out.println(purchases.length + " transações recebidos!");
            }
        });*/

        Thread.sleep(120 * 1000L);
    }
}
