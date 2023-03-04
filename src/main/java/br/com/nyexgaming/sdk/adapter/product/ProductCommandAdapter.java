package br.com.nyexgaming.sdk.adapter.product;

import br.com.nyexgaming.sdk.models.product.ProductCommand;
import br.com.nyexgaming.sdk.models.product.ProductCommandType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;

public class ProductCommandAdapter {

    public static ProductCommand[] read(JSONArray objects) {
        ProductCommand[] commands = new ProductCommand[objects.length()];

        for (int i = 0; i < commands.length; i++) {
            commands[i] = read(objects.getJSONObject(i));
        }

        return commands;
    }

    public static ProductCommand read(JSONObject object) {
        return new ProductCommand(
                object.getLong("id_comando"),
                object.getLong("id_loja"),
                object.getLong("id_produto"),
                object.getString("comando"),
                object.getString("args"),
                object.getBoolean("console"),
                object.getBoolean("temporario"),
                object.getInt("dias_duracao"),
                ProductCommandType.valueOf(object.getString("type")),
                Instant.parse(object.getString("criado_em")).toEpochMilli(),
                Instant.parse(object.getString("atualizado_em")).toEpochMilli()
        );
    }

    public static JSONArray write(ProductCommand[] comandos) {
        JSONArray objects = new JSONArray();

        for (ProductCommand command : comandos) {
            objects.put(write(command));
        }

        return objects;
    }

    public static JSONObject write(ProductCommand command) {
        JSONObject object = new JSONObject();

        object.put("id_comando", command.id_comando());
        object.put("id_loja", command.id_loja());
        object.put("id_produto", command.id_produto());
        object.put("comando", command.comando());
        object.put("args", command.args());
        object.put("console", command.console());
        object.put("temporario", command.temporario());
        object.put("dias_duracao", command.dias_duracao());
        object.put("type", command.type().name().toLowerCase());
        object.put("criado_em", Instant.ofEpochMilli(command.criado_em()).toString());
        object.put("atualizado_em", Instant.ofEpochMilli(command.atualizado_em()).toString());

        return object;
    }
}
