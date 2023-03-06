package br.com.nyexgaming.sdk.errors;

public class RequestFailedException extends Exception {

    private int statusCode;

    public RequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestFailedException(int statusCode, String message) {
        super(message + " (" + statusCode + ")");

        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
