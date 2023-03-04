package br.com.nyexgaming.sdk;

import br.com.nyexgaming.sdk.utils.HTTPClient;
import br.com.nyexgaming.sdk.data.adapter.purchase.PurchaseAdapter;
import br.com.nyexgaming.sdk.data.errors.NetworkErrorException;
import br.com.nyexgaming.sdk.data.errors.RequestFailedException;
import br.com.nyexgaming.sdk.data.errors.TokenFailureException;
import br.com.nyexgaming.sdk.data.models.purchase.Purchase;
import br.com.nyexgaming.sdk.data.models.purchase.PurchaseStatus;
import br.com.nyexgaming.sdk.utils.WebSocket;
import org.json.JSONArray;
import org.json.JSONObject;

public class NyexAPI {

    private final HTTPClient http;
    private final WebSocket socket;

    public NyexAPI(String storeId, String serverId) {
        this.http = new HTTPClient(storeId, serverId);
        this.socket = new WebSocket(storeId, serverId);
    }

    public Purchase[] getTransactions() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONArray(this.http.GET("/ps/transacoes/")));
    }

    public Purchase getTransactionById(long transactionId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONObject(this.http.GET("/ps/transacoes/" + transactionId)));
    }

    public Purchase[] getTransactionsByProduct(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONArray(this.http.GET("/ps/transacoes/p/" + productId)));
    }

    public Purchase[] getTransactionsByStatus(PurchaseStatus status) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONArray(this.http.GET("/ps/transacoes/s/" + status.statusCode)));
    }

    public Purchase[] getTransactionsByUser(String user) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONArray(this.http.GET("/ps/transacoes/u/" + user)));
    }

    public String update(Purchase purchase) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return this.http.POST("ps/transacoes/" + purchase.id_transacao(), PurchaseAdapter.write(purchase).toString());
    }

    public HTTPClient getHttpClient() {
        return this.http;
    }

    public WebSocket getWebSocketClient() {
        return this.socket;
    }
}
