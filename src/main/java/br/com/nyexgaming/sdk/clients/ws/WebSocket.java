package br.com.nyexgaming.sdk.clients.ws;

import jakarta.websocket.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebSocket extends Endpoint implements MessageHandler.Whole<String> {

    private final WebSocketConfig config;
    private final WebSocketContainer container;
    private final WebSocketHandler handler;

    private Session session;

    public WebSocket(WebSocketConfig config, WebSocketHandler handler) {
        this.config = config;
        this.container = ContainerProvider.getWebSocketContainer();
        this.handler = handler;
    }

    public void connect() throws URISyntaxException, DeploymentException, IOException {
        if (session != null && session.isOpen()) return;

        this.session = container.connectToServer(this, config.build(), new URI("wss://ws.nyexgaming.com.br"));
        this.session.addMessageHandler(this);
    }

    public void disconnect() throws IOException {
        if (session == null || !session.isOpen()) return;

        this.session.close();
        this.session = null;
    }

    public void sendMessage(String message) throws IOException {
        if (session == null || !session.isOpen()) return;

        session.getBasicRemote().sendText(message);
    }

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        handler.handleOpen();
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        // TODO: reconnect

        handler.handleClose();
    }

    @Override
    public void onMessage(String message) {
        try {
            handler.handleMessage(new JSONObject(message));
        } catch (JSONException throwable) {
            handler.handleError(throwable);
        }
    }

    @Override
    public void onError(Session session, Throwable throwable) {
        handler.handleError(throwable);
    }
}
