import br.com.nyexgaming.sdk.NyexGaming;
import br.com.nyexgaming.sdk.endpoints.transactions.Transaction;
import br.com.nyexgaming.sdk.http.exceptions.NetworkErrorException;
import br.com.nyexgaming.sdk.http.exceptions.RequestFailedException;
import br.com.nyexgaming.sdk.http.exceptions.TokenFailureException;
import com.google.gson.Gson;

public class ClientTest {

    public static void main(String[] args) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        NyexGaming nyexGaming = new NyexGaming("storeId", "serverId");

        try {
            for (Transaction transaction : nyexGaming.getTransactions()) {
                System.out.println(new Gson().toJson(transaction));
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getResponseCode());
            throw e;
        }
    }
}
