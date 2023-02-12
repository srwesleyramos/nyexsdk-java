package br.com.nyexgaming.sdk.endpoints.transactions;

public enum TransactionStatus {

    PENDING(0), PAID(1), DELIVERED(2), REVERSED(3), FAIL(4);

    public final int statusCode;

    TransactionStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public static TransactionStatus valueOf(int statusCode) {
        for (TransactionStatus value : TransactionStatus.values()) {
            if (value.statusCode == statusCode) {
                return value;
            }
        }

        return null;
    }
}
