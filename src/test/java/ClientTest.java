import br.com.nyexgaming.sdk.NyexAPI;
import br.com.nyexgaming.sdk.utils.exceptions.NetworkErrorException;
import br.com.nyexgaming.sdk.utils.exceptions.RequestFailedException;
import br.com.nyexgaming.sdk.utils.exceptions.TokenFailureException;
import br.com.nyexgaming.sdk.models.deliveries.Transaction;

public class ClientTest {

    public static void main(String[] args) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        // NyexAPI nyexAPI = new NyexAPI("6dfddb89-e14a-4ae8-a3b1-d7da276f9122", "f2a31f7a-72c4-4d12-b87d-669d0836ae38");

        NyexAPI nyexAPI = new NyexAPI("not-found", "not-found");

        for (Transaction transaction : nyexAPI.getTransactions()) {
            // nyexAPI.update(transaction);
        }
    }
}
