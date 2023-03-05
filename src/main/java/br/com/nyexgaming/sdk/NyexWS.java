package br.com.nyexgaming.sdk;

import br.com.nyexgaming.sdk.clients.ws.WebSocket;
import br.com.nyexgaming.sdk.clients.ws.WebSocketConfig;
import br.com.nyexgaming.sdk.clients.ws.WebSocketHandler;
import jakarta.websocket.DeploymentException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

public class NyexWS extends WebSocketHandler {

    // TODO: trocar p WebSocketHandler para um próprio que contenha os eventos da Nyex.
    private final Set<WebSocketHandler> handlers = new HashSet<>();

    private final WebSocket ws;

    public NyexWS(String storeId, String serverId) {
        this.ws = new WebSocket(new WebSocketConfig(storeId, serverId), this);

        try {
            this.ws.connect();
        } catch (DeploymentException | IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void addHandler(WebSocketHandler handler) {
        handlers.add(handler);
    }

    public void removeHandler(WebSocketHandler handler) {
        handlers.remove(handler);
    }

    @Override
    public void handleOpen() {
        handlers.forEach(WebSocketHandler::handleOpen);
    }

    @Override
    public void handleClose() {
        handlers.forEach(WebSocketHandler::handleClose);
    }

    @Override
    public void handleMessage(JSONObject message) {
        // TODO: nyex::connect event

        handlers.forEach(handler -> handler.handleMessage(message));
    }

    @Override
    public void handleError(Throwable throwable) {
        // TODO: lidar com os erros
    }

    public WebSocket getWebSocketClient() {
        return this.ws;
    }
}
