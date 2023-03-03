package br.com.nyexgaming.sdk.data.models.purchase;

import java.util.Arrays;

public enum PurchaseStatus {

    PENDING(0), PAID(1), CHARGEBACK(2), FAIL(3);

    public final int statusCode;

    PurchaseStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public static PurchaseStatus valueOf(int statusCode) {
        return Arrays.stream(values()).filter(t -> t.statusCode == statusCode).findFirst().orElse(FAIL);
    }
}
