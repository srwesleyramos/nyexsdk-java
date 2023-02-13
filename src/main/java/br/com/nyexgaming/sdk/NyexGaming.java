package br.com.nyexgaming.sdk;

import br.com.nyexgaming.sdk.endpoints.categories.Category;
import br.com.nyexgaming.sdk.endpoints.products.Product;
import br.com.nyexgaming.sdk.endpoints.transactions.Transaction;
import br.com.nyexgaming.sdk.endpoints.transactions.TransactionStatus;
import br.com.nyexgaming.sdk.http.HTTPUtils;
import br.com.nyexgaming.sdk.http.exceptions.NetworkErrorException;
import br.com.nyexgaming.sdk.http.exceptions.RequestFailedException;
import br.com.nyexgaming.sdk.http.exceptions.TokenFailureException;
import com.google.gson.Gson;

public class NyexGaming {

    private final HTTPUtils http;

    public NyexGaming(String storeId, String serverId) {
        this.http = new HTTPUtils(storeId, serverId);
    }

    public Category[] getCategories() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/ps/categorias/");

        return new Gson().fromJson(content, Category[].class);
    }

    public Category getCategoryById(long categoryId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/ps/categorias/" + categoryId);

        return new Gson().fromJson(content, Category.class);
    }

    public Product getProductById(long categoryId, long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/ps/categorias/" + categoryId + "/" + productId);

        return new Gson().fromJson(content, Product.class);
    }

    public Transaction[] getTransactions() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/ps/transacoes/");

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction getTransactionById(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/ps/transacoes/" + productId);

        return new Gson().fromJson(content, Transaction.class);
    }

    public Transaction[] getTransactionsByProduct(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/ps/transacoes/p/" + productId);

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction[] getTransactionsByStatus(TransactionStatus status) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/ps/transacoes/s/" + status.statusCode);

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction[] getTransactionsByUser(String id) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/ps/transacoes/u/" + id);

        return new Gson().fromJson(content, Transaction[].class);
    }

    public void update(Transaction transaction) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        this.http.POST("https://api.nyexgaming.com.br/v1/ps/transacoes/" + transaction.id_transacao, new Gson().toJson(transaction));
    }

    public HTTPUtils getHttp() {
        return http;
    }
}
