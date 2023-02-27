package br.com.nyexgaming.sdk.utils;

import br.com.nyexgaming.sdk.utils.exceptions.NetworkErrorException;
import br.com.nyexgaming.sdk.utils.exceptions.RequestFailedException;
import br.com.nyexgaming.sdk.utils.exceptions.TokenFailureException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class HTTPUtils {

    private final String API_PREFIX = "https://api.nyexgaming.com.br/v1/";
    private final String storeId, serverId;

    public HTTPUtils(String storeId, String serverId) {
        this.storeId = "Bearer " + storeId;
        this.serverId = "Bearer " + serverId;
    }

    public String GET(String endpoint) throws NetworkErrorException, TokenFailureException, RequestFailedException {
        try {
            HttpURLConnection request = (HttpURLConnection) new URL(API_PREFIX + endpoint).openConnection();

            request.setRequestProperty("Content-Type", "application/json");
            request.setRequestProperty("store-id-authorization", this.storeId);
            request.setRequestProperty("server-id-authorization", this.serverId);

            int statusCode = request.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK || statusCode == HttpURLConnection.HTTP_ACCEPTED) {
                return getResponseContent(request.getInputStream());
            }

            JsonObject statusBody = new Gson().fromJson(getResponseContent(request.getErrorStream()), JsonObject.class);

            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                throw new TokenFailureException(statusBody.get("message").getAsString());
            }

            throw new RequestFailedException(statusCode, statusBody.get("message").getAsString());
        } catch (IOException e) {
            throw new NetworkErrorException("Não foi possível estabelecer uma conexão com a Internet. Verifique sua conexão de rede e tente novamente.");
        }
    }

    public String POST(String endpoint, String content) throws NetworkErrorException, TokenFailureException, RequestFailedException {
        try {
            HttpURLConnection request = (HttpURLConnection) new URL(API_PREFIX + endpoint).openConnection();

            request.setDoOutput(true);
            request.setRequestMethod("POST");
            request.setRequestProperty("Content-Type", "application/json");
            request.setRequestProperty("store-id-authorization", this.storeId);
            request.setRequestProperty("server-id-authorization", this.serverId);

            try (OutputStreamWriter writer = new OutputStreamWriter(request.getOutputStream())) {
                writer.write(content);
            }

            int statusCode = request.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK || statusCode == HttpURLConnection.HTTP_CREATED) {
                return getResponseContent(request.getInputStream());
            }

            JsonObject statusBody = new Gson().fromJson(getResponseContent(request.getErrorStream()), JsonObject.class);

            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                throw new TokenFailureException(statusBody.get("message").getAsString());
            }

            throw new RequestFailedException(statusCode, statusBody.get("message").getAsString());
        } catch (IOException e) {
            throw new NetworkErrorException("Não foi possível estabelecer uma conexão com a Internet. Verifique sua conexão de rede e tente novamente.");
        }
    }

    public String getResponseContent(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining());
    }
}
