package br.com.nyexgaming.sdk;

import br.com.nyexgaming.sdk.endpoints.categories.Category;
import br.com.nyexgaming.sdk.endpoints.products.Product;
import br.com.nyexgaming.sdk.endpoints.transactions.Transaction;
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
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/categorias/");

        return new Gson().fromJson(content, Category[].class);
    }

    public void update(Category category) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        this.http.POST("https://api.nyexgaming.com.br/v1/categorias/", new Gson().toJson(category));
    }

    public Product[] getProducts() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/produtos/");

        return new Gson().fromJson(content, Product[].class);
    }

    public Product[] getProductsByCategory(String category) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/produtos/" + category);

        return new Gson().fromJson(content, Product[].class);
    }

    public Product getProductById(long id) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/produtos/" + id);

        return new Gson().fromJson(content, Product.class);
    }

    public void update(Product product) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        this.http.POST("https://api.nyexgaming.com.br/v1/produtos/", new Gson().toJson(product));
    }

    public Transaction[] getTransactions() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/transacoes/");

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction[] getTransactionsByStatus(String status) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/transacoes/" + status);

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction[] getTransactionsByProduct(long product) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/transacoes/" + product);

        return new Gson().fromJson(content, Transaction[].class);
    }

    public Transaction getTransactionById(long id) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/transacoes/" + id);

        return new Gson().fromJson(content, Transaction.class);
    }

    public void update(Transaction transaction) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        this.http.POST("https://api.nyexgaming.com.br/v1/transacoes/", new Gson().toJson(transaction));
    }

    public HTTPUtils getHttp() {
        return http;
    }
}
