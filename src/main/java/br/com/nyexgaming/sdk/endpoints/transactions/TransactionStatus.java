package br.com.nyexgaming.sdk.endpoints.transactions;

public enum TransactionStatus {

    PENDING(0), PAID(1), REVERSED(2), FAIL(3);

    private final int statusCode;

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
