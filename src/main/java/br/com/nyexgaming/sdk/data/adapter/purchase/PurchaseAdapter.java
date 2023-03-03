package br.com.nyexgaming.sdk.data.adapter.purchase;

import br.com.nyexgaming.sdk.data.adapter.product.ProductAdapter;
import br.com.nyexgaming.sdk.data.models.purchase.Purchase;
import br.com.nyexgaming.sdk.data.models.purchase.PurchaseDelivery;
import br.com.nyexgaming.sdk.data.models.purchase.PurchaseStatus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;

public class PurchaseAdapter {

    public static Purchase[] read(JSONArray objects) {
        Purchase[] purchases = new Purchase[objects.length()];

        for (int i = 0; i < purchases.length; i++) {
            purchases[i] = read(objects.getJSONObject(i));
        }

        return purchases;
    }

    public static Purchase read(JSONObject object) {
        return new Purchase(
                object.getLong("id_transacao"),
                object.getLong("id_cupom"),
                object.getLong("id_loja"),
                object.getLong("id_servidor"),
                PurchaseStatus.valueOf(object.getInt("status")),
                PurchaseDelivery.valueOf(object.getInt("entregue")),
                object.getString("identificador"),
                object.getString("email"),
                object.getString("gateway"),
                Double.parseDouble(object.getString("valor")) / 100,
                object.getString("hex_transacao"),
                object.getString("external_reference"),
                ProductAdapter.read(object.getJSONArray("produtos")),
                Instant.parse(object.getString("criado_em")).toEpochMilli(),
                Instant.parse(object.getString("atualizado_em")).toEpochMilli()
        );
    }

    public static JSONArray write(Purchase[] purchases) {
        JSONArray objects = new JSONArray();

        for (Purchase purchase : purchases) {
            objects.put(write(purchase));
        }

        return objects;
    }

    public static JSONObject write(Purchase purchase) {
        JSONObject object = new JSONObject();

        object.put("id_transacao", purchase.id_transacao());
        object.put("id_cupom", purchase.id_cupom());
        object.put("id_loja", purchase.id_loja());
        object.put("id_servidor", purchase.id_servidor());
        object.put("status", purchase.status().statusCode);
        object.put("entregue", purchase.entregue().statusCode);
        object.put("identificador", purchase.identificador());
        object.put("email", purchase.email());
        object.put("gateway", purchase.gateway());
        object.put("valor", Double.toString(purchase.valor() * 100));
        object.put("hex_transacao", purchase.hex_transacao());
        object.put("external_reference", purchase.external_reference());
        object.put("produtos", ProductAdapter.write(purchase.produtos()));
        object.put("criado_em", Instant.ofEpochMilli(purchase.criado_em()).toString());
        object.put("atualizado_em", Instant.ofEpochMilli(purchase.atualizado_em()).toString());

        return object;
    }
}
