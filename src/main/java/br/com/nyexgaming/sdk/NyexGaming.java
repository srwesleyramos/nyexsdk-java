package br.com.nyexgaming.sdk;

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

    public Transaction[] getTransactions() throws NetworkErrorException, RequestFailedException, TokenFailureException {
        String content = this.http.GET("https://api.nyexgaming.com.br/v1/transacoes");

        return new Gson().fromJson(content, Transaction[].class);
    }

    public HTTPUtils getHttp() {
        return http;
    }
}
