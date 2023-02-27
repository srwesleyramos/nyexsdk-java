package br.com.nyexgaming.sdk;

import br.com.nyexgaming.sdk.utils.HTTPUtils;
import br.com.nyexgaming.sdk.utils.exceptions.NetworkErrorException;
import br.com.nyexgaming.sdk.utils.exceptions.RequestFailedException;
import br.com.nyexgaming.sdk.utils.exceptions.TokenFailureException;
import br.com.nyexgaming.sdk.models.deliveries.Transaction;
import br.com.nyexgaming.sdk.models.deliveries.TransactionStatus;
import com.google.gson.Gson;

public class NyexAPI {

    private final HTTPUtils http;

    public NyexAPI(String storeId, String serverId) {
        this.http = new HTTPUtils(storeId, serverId);
    }

    public Transaction[] getTransactions() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/");

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction getTransactionById(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/" + productId);

        return new Gson().fromJson(content, Transaction.class);
    }

    public Transaction[] getTransactionsByProduct(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/p/" + productId);

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction[] getTransactionsByStatus(TransactionStatus status) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/s/" + status.statusCode);

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction[] getTransactionsByUser(String id) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("ps/transacoes/u/" + id);

        return new Gson().fromJson(content, Transaction[].class);
    }

    public String update(Transaction transaction) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return this.http.POST("ps/transacoes/" + transaction.id_transacao, new Gson().toJson(transaction));
    }

    public HTTPUtils getHttp() {
        return http;
    }
}
