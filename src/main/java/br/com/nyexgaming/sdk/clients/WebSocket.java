package br.com.nyexgaming.sdk.clients;

import jakarta.websocket.*;
import org.json.JSONObject;

import java.io.IOException;

public class WebSocket extends Endpoint {

    private final String storeId, serverId;

    private Executor executor;
    private Session session;

    public WebSocket(String storeId, String serverId) {
        this.storeId = "Bearer " + storeId;
        this.serverId = "Bearer " + serverId;
    }

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        this.session = session;
        this.session.addMessageHandler(new MessageHandler.Whole<JSONObject>() {
            @Override
            public void onMessage(JSONObject object) {
                if (executor == null) return;

                executor.execute(object);
            }
        });
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println(closeReason.toString());
    }

    @Override
    public void onError(Session session, Throwable thr) {
        thr.printStackTrace();
    }

    public void sendMessage(JSONObject object) throws IOException {
        if (this.session == null) return;

        this.session.getBasicRemote().sendText(object.toString());
    }

    public void close() throws IOException {
        if (this.session == null) return;

        this.session.close();
        this.session = null;
    }

    public WebSocket setExecutor(Executor executor) {
        this.executor = executor;
        return this;
    }

    public interface Executor {
        void execute(JSONObject object);
    }
}
