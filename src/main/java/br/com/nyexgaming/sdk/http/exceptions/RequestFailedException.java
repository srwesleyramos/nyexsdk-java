package br.com.nyexgaming.sdk.http.exceptions;

public class RequestFailedException extends Exception {

    private final int responseCode;

    public RequestFailedException(String message, int responseCode) {
        super(message + " (" + responseCode + ")");

        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
