package br.com.nyexgaming.sdk.models.deliveries;

public enum TransactionStatus {

    PENDING(0), PAID(1), REVERSED(2), FAIL(3);

    public final int statusCode;

    TransactionStatus(int statusCode) {
        this.statusCode = statusCode;
    }
}
