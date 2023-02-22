package br.com.nyexgaming.sdk.http;

import br.com.nyexgaming.sdk.http.exceptions.NetworkErrorException;
import br.com.nyexgaming.sdk.http.exceptions.RequestFailedException;
import br.com.nyexgaming.sdk.http.exceptions.TokenFailureException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPUtils {

    private final String storeId, serverId;

    public HTTPUtils(String storeId, String serverId) {
        this.storeId = "Bearer " + storeId;
        this.serverId = "Bearer " + serverId;
    }

    public String GET(String url) throws NetworkErrorException, TokenFailureException, RequestFailedException {
        try {
            HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();

            request.setConnectTimeout(5000);
            request.setReadTimeout(5000);

            request.setRequestProperty("store-id-authorization", this.storeId);
            request.setRequestProperty("server-id-authorization", this.serverId);
            request.setRequestProperty("Content-Type", "application/json");
            request.setRequestProperty("X-HTTP-Method-Override", "GET");

            request.connect();

            if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return readHttpContent(request.getInputStream());
            }

            if (request.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED || request.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                throw new TokenFailureException("the provided token is invalid");
            }

            throw new RequestFailedException("there was an error sending the request", request.getResponseCode());
        } catch (IOException e) {
            throw new NetworkErrorException("failed to connect, check your internet");
        }
    }

    public String POST(String url, String content) throws NetworkErrorException, TokenFailureException, RequestFailedException {
        try {
            HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();

            request.setReadTimeout(5000);
            request.setConnectTimeout(5000);
            request.setDoOutput(true);

            request.setRequestProperty("store-id-authorization", this.storeId);
            request.setRequestProperty("server-id-authorization", this.serverId);
            request.setRequestProperty("Content-Type", "application/json");
            request.setRequestProperty("X-HTTP-Method-Override", "POST");

            request.connect();

            OutputStreamWriter buffer = new OutputStreamWriter(request.getOutputStream());
            buffer.write(content);
            buffer.close();

            if (request.getResponseCode() == HttpURLConnection.HTTP_OK || request.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                return readHttpContent(request.getInputStream());
            }

            if (request.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED || request.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                throw new TokenFailureException("the provided token is invalid");
            }

            throw new RequestFailedException("there was an error sending the request", request.getResponseCode());
        } catch (IOException e) {
            throw new NetworkErrorException("failed to connect, check your internet");
        }
    }

    public String readHttpContent(InputStream inputStream) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder string = new StringBuilder();

        for (String str = buffer.readLine(); str != null; str = buffer.readLine()) {
            string.append(str);
        }

        return string.toString();
    }
}
