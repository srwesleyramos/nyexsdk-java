package br.com.nyexgaming.sdk.adapter.product;

import br.com.nyexgaming.sdk.models.product.Product;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;

public class ProductAdapter {

    public static Product[] read(JSONArray objects) {
        Product[] products = new Product[objects.length()];

        for (int i = 0; i < products.length; i++) {
            products[i] = read(objects.getJSONObject(i));
        }

        return products;
    }

    public static Product read(JSONObject object) {
        return new Product(
                object.getLong("id_produto"),
                object.getLong("id_categoria"),
                object.getLong("id_loja"),
                object.getString("nome"),
                object.getString("detalhes"),
                object.getString("imagem"),
                Double.parseDouble(object.getString("preco")) / 100,
                object.getInt("estoque"),
                object.getInt("quantidade"),
                object.getBoolean("usar_estoque"),
                object.getBoolean("deletar_sem_estoque"),
                ProductCommandAdapter.read(object.getJSONArray("comandos")),
                Instant.parse(object.getString("criado_em")).toEpochMilli(),
                Instant.parse(object.getString("atualizado_em")).toEpochMilli()
        );
    }

    public static JSONArray write(Product[] products) {
        JSONArray objects = new JSONArray();

        for (Product product : products) {
            objects.put(write(product));
        }

        return objects;
    }

    public static JSONObject write(Product product) {
        JSONObject object = new JSONObject();

        object.put("id_produto", product.id_produto());
        object.put("id_categoria", product.id_categoria());
        object.put("id_loja", product.id_loja());
        object.put("nome", product.nome());
        object.put("detalhes", product.detalhes());
        object.put("imagem", product.imagem());
        object.put("preco", Double.toString(product.preco() * 100));
        object.put("estoque", product.estoque());
        object.put("quantidade", product.quantidade());
        object.put("usar_estoque", product.usar_estoque());
        object.put("deletar_sem_estoque", product.deletar_sem_estoque());
        object.put("comandos", ProductCommandAdapter.write(product.comandos()));
        object.put("criado_em", Instant.ofEpochMilli(product.criado_em()).toString());
        object.put("atualizado_em", Instant.ofEpochMilli(product.atualizado_em()).toString());

        return object;
    }
}
