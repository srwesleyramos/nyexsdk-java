package br.com.nyexgaming.sdk;

import br.com.nyexgaming.sdk.data.errors.NetworkErrorException;
import br.com.nyexgaming.sdk.data.errors.RequestFailedException;
import br.com.nyexgaming.sdk.data.errors.TokenFailureException;
import br.com.nyexgaming.sdk.data.models.purchase.Purchase;
import br.com.nyexgaming.sdk.data.models.purchase.PurchaseStatus;
import br.com.nyexgaming.sdk.http.HTTPUtils;
import com.google.gson.Gson;

public class NyexAPI {

    private final HTTPUtils http;

    public NyexAPI(String storeId, String serverId) {
        this.http = new HTTPUtils(storeId, serverId);
    }

    public Purchase[] getTransactions() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/");

        return new Gson().fromJson(content, Purchase[].class);
    }

    public Purchase getTransactionById(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/" + productId);

        return new Gson().fromJson(content, Purchase.class);
    }

    public Purchase[] getTransactionsByProduct(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/p/" + productId);

        return new Gson().fromJson(content, Purchase[].class);
    }

    public Purchase[] getTransactionsByStatus(PurchaseStatus status) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/s/" + status.statusCode);

        return new Gson().fromJson(content, Purchase[].class);
    }

    public Purchase[] getTransactionsByUser(String id) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/u/" + id);

        return new Gson().fromJson(content, Purchase[].class);
    }

    public String update(Purchase purchase) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return this.http.POST("ps/transacoes/" + purchase.id_transacao, new Gson().toJson(purchase));
    }

    public HTTPUtils getHttp() {
        return http;
    }
}
