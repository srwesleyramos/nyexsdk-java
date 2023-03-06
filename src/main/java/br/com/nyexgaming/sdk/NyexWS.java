package br.com.nyexgaming.sdk;

import br.com.nyexgaming.sdk.clients.ws.WebSocket;
import br.com.nyexgaming.sdk.clients.ws.WebSocketConfig;
import br.com.nyexgaming.sdk.errors.NetworkErrorException;
import br.com.nyexgaming.sdk.errors.RequestFailedException;
import org.json.JSONObject;

public class NyexWS {

    private final WebSocket ws;

    public NyexWS(String storeId, String serverId) {
        this.ws = new WebSocket(new WebSocketConfig(storeId, serverId), null);
    }

    public void connect(Game game) throws NetworkErrorException, RequestFailedException {
        this.ws.connect();
        this.ws.send(new JSONObject().put("subscribe", game.event()));
    }

    public void disconnect() throws RequestFailedException {
        this.ws.disconnect();
    }

    // TODO: handler of messages
    // TODO: 1. nyex::connect

    public enum Game {
        FIVEM("nyex::fivem::execute::event"), MINECRAFT("nyex::minecraft::execute::event");

        private final String event;

        Game(String event) {
            this.event = event;
        }

        public String event() {
            return event;
        }
    }
}
