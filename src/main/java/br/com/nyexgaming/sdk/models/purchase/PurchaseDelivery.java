package br.com.nyexgaming.sdk.models.purchase;

import java.util.Arrays;

public enum PurchaseDelivery {

    PENDING(0), DELIVERED(1), BLOCKED(2), FAIL(3);

    public final int statusCode;

    PurchaseDelivery(int statusCode) {
        this.statusCode = statusCode;
    }

    public static PurchaseDelivery valueOf(int statusCode) {
        return Arrays.stream(values()).filter(t -> t.statusCode == statusCode).findFirst().orElse(FAIL);
    }
}
