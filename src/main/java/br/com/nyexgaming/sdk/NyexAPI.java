package br.com.nyexgaming.sdk;

import br.com.nyexgaming.sdk.adapter.category.CategoryAdapter;
import br.com.nyexgaming.sdk.adapter.product.ProductAdapter;
import br.com.nyexgaming.sdk.adapter.purchase.PurchaseAdapter;
import br.com.nyexgaming.sdk.clients.http.HTTP;
import br.com.nyexgaming.sdk.errors.NetworkErrorException;
import br.com.nyexgaming.sdk.errors.RequestFailedException;
import br.com.nyexgaming.sdk.errors.TokenFailureException;
import br.com.nyexgaming.sdk.models.category.Category;
import br.com.nyexgaming.sdk.models.product.Product;
import br.com.nyexgaming.sdk.models.purchase.Purchase;
import br.com.nyexgaming.sdk.models.purchase.PurchaseStatus;
import org.json.JSONArray;
import org.json.JSONObject;

public class NyexAPI {

    private final HTTP http;

    public NyexAPI(String storeId, String serverId) {
        this.http = new HTTP(storeId, serverId);
    }

    @Deprecated
    public Category[] getCategories() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return CategoryAdapter.read(new JSONArray(this.http.GET("/v1/ps/categorias/")));
    }

    @Deprecated
    public Category getCategoryById(long categoryId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return CategoryAdapter.read(new JSONObject(this.http.GET("/v1/ps/categorias/" + categoryId)));
    }

    @Deprecated
    public Product[] getProducts() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return ProductAdapter.read(new JSONArray(this.http.GET("/v1/ps/produtos/")));
    }

    @Deprecated
    public Product getProductById(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return ProductAdapter.read(new JSONObject(this.http.GET("/v1/ps/produtos/" + productId)));
    }

    @Deprecated
    public Product[] getProductsByCategory(long categoryId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return ProductAdapter.read(new JSONArray(this.http.GET("/v1/ps/produtos/c/" + categoryId)));
    }

    public Purchase[] getTransactions() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONArray(this.http.GET("/v1/ps/transacoes/")));
    }

    public Purchase getTransactionById(long transactionId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONObject(this.http.GET("/v1/ps/transacoes/" + transactionId)));
    }

    public Purchase[] getTransactionsByProduct(long productId) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONArray(this.http.GET("/v1/ps/transacoes/p/" + productId)));
    }

    public Purchase[] getTransactionsByStatus(PurchaseStatus status) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONArray(this.http.GET("/v1/ps/transacoes/s/" + status.statusCode)));
    }

    public Purchase[] getTransactionsByUser(String user) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        return PurchaseAdapter.read(new JSONArray(this.http.GET("/v1/ps/transacoes/u/" + user)));
    }

    public void update(Purchase purchase) throws NetworkErrorException, RequestFailedException, TokenFailureException {
        this.http.POST("/v1/ps/transacoes/" + purchase.id_transacao(), PurchaseAdapter.write(purchase).toString());
    }

    public HTTP getHttpClient() {
        return this.http;
    }
}
