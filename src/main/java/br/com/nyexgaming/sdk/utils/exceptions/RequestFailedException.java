package br.com.nyexgaming.sdk.utils.exceptions;

public class RequestFailedException extends Exception {

    private final int statusCode;

    public RequestFailedException(int statusCode, String message) {
        super(message + " (" + statusCode + ")");

        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
