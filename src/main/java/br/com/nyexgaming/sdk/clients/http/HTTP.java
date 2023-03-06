package br.com.nyexgaming.sdk.clients.http;

import br.com.nyexgaming.sdk.errors.NetworkErrorException;
import br.com.nyexgaming.sdk.errors.RequestFailedException;
import br.com.nyexgaming.sdk.errors.TokenFailureException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class HTTP {

    private static final String API_PREFIX = "https://api.nyexgaming.com.br";

    private final String storeId, serverId;

    public HTTP(String storeId, String serverId) {
        this.storeId = "Bearer " + storeId;
        this.serverId = "Bearer " + serverId;
    }

    public String GET(String endpoint) throws NetworkErrorException, TokenFailureException, RequestFailedException {
        try {
            HttpURLConnection request = (HttpURLConnection) new URL(API_PREFIX + endpoint).openConnection();

            request.setRequestProperty("Content-Type", "application/json");
            request.setRequestProperty("store-id-authorization", this.storeId);
            request.setRequestProperty("server-id-authorization", this.serverId);

            return getResponse(request);
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

            return getResponse(request);
        } catch (IOException e) {
            throw new NetworkErrorException("Não foi possível estabelecer uma conexão com a Internet. Verifique sua conexão de rede e tente novamente.");
        }
    }

    public String getResponse(HttpURLConnection request) throws TokenFailureException, RequestFailedException, IOException {
        int statusCode = request.getResponseCode();

        if (statusCode == HttpURLConnection.HTTP_OK || statusCode == HttpURLConnection.HTTP_CREATED) {
            return getResponseContent(request.getInputStream());
        }

        JSONObject object = new JSONObject(getResponseContent(request.getErrorStream()));

        if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
            throw new TokenFailureException(object.getString("message"));
        }

        throw new RequestFailedException(statusCode, object.getString("message"));
    }

    public String getResponseContent(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining());
    }
}
