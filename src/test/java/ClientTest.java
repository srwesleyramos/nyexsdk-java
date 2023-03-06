import br.com.nyexgaming.sdk.NyexAPI;
import br.com.nyexgaming.sdk.data.models.purchase.Purchase;
import br.com.nyexgaming.sdk.data.models.purchase.PurchaseDelivery;
import br.com.nyexgaming.sdk.errors.NetworkErrorException;
import br.com.nyexgaming.sdk.errors.RequestFailedException;
import br.com.nyexgaming.sdk.errors.TokenFailureException;

public class ClientTest {

    public static void main(String[] args) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        NyexAPI nyex = new NyexAPI("6dfddb89-e14a-4ae8-a3b1-d7da276f9122", "f2a31f7a-72c4-4d12-b87d-669d0836ae38");

        for (Purchase purchase : nyex.getTransactions()) {
            nyex.update(purchase.setEntregue(PurchaseDelivery.DELIVERED));
        }
    }
}
