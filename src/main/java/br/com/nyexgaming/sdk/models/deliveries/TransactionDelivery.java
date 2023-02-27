package br.com.nyexgaming.sdk.models.deliveries;

public enum TransactionDelivery {

    PENDING(0), DELIVERED(1), DELIVERY_FAILURE(2), BLOCKED(3);

    public final int statusCode;

    TransactionDelivery(int statusCode) {
        this.statusCode = statusCode;
    }
}
