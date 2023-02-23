import br.com.nyexgaming.sdk.NyexGaming;
import br.com.nyexgaming.sdk.endpoints.transactions.Transaction;
import br.com.nyexgaming.sdk.http.exceptions.NetworkErrorException;
import br.com.nyexgaming.sdk.http.exceptions.RequestFailedException;
import br.com.nyexgaming.sdk.http.exceptions.TokenFailureException;

public class ClientTest {

    public static void main(String[] args) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        NyexGaming nyexGaming = new NyexGaming("6dfddb89-e14a-4ae8-a3b1-d7da276f9122", "f2a31f7a-72c4-4d12-b87d-669d0836ae38");

        try {
            for (Transaction transaction : nyexGaming.getTransactions()) {
                nyexGaming.update(transaction);
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getResponseCode());
            throw e;
        }
    }
}
