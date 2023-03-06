package br.com.nyexgaming.sdk.data.adapter.category;

import br.com.nyexgaming.sdk.data.models.category.Category;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;

public class CategoryAdapter {

    public static Category[] read(JSONArray objects) {
        Category[] categories = new Category[objects.length()];

        for (int i = 0; i < categories.length; i++) {
            categories[i] = read(objects.getJSONObject(i));
        }

        return categories;
    }

    public static Category read(JSONObject object) {
        return new Category(
                object.getLong("id_categoria"),
                object.getLong("id_loja"),
                object.getLong("id_servidor"),
                object.getString("nome"),
                object.getString("descricao"),
                object.getString("imagem"),
                object.getString("slug"),
                object.getInt("position"),
                Instant.parse(object.getString("criado_em")).toEpochMilli(),
                Instant.parse(object.getString("atualizado_em")).toEpochMilli()
        );
    }

    public static JSONArray write(Category[] categories) {
        JSONArray objects = new JSONArray();

        for (Category category : categories) {
            objects.put(write(category));
        }

        return objects;
    }

    public static JSONObject write(Category category) {
        JSONObject object = new JSONObject();

        object.put("id_categoria", category.id_categoria());
        object.put("id_loja", category.id_loja());
        object.put("id_servidor", category.id_servidor());
        object.put("nome", category.nome());
        object.put("descricao", category.descricao());
        object.put("imagem", category.imagem());
        object.put("slug", category.slug());
        object.put("position", category.position());
        object.put("criado_em", Instant.ofEpochMilli(category.criado_em()).toString());
        object.put("atualizado_em", Instant.ofEpochMilli(category.atualizado_em()).toString());

        return object;
    }
}
