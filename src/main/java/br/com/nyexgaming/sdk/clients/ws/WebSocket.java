package br.com.nyexgaming.sdk.clients.ws;

import br.com.nyexgaming.sdk.errors.NetworkErrorException;
import br.com.nyexgaming.sdk.errors.RequestFailedException;
import jakarta.websocket.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebSocket extends Endpoint implements MessageHandler.Whole<String> {

    private static final String WS_URL = "ws://192.168.18.7:8080";

    private final WebSocketConfig config;
    private final WebSocketContainer container;
    private final WebSocketHandler handler;

    private Session session;

    public WebSocket(WebSocketConfig config, WebSocketHandler handler) {
        this.config = config;
        this.container = ContainerProvider.getWebSocketContainer();
        this.handler = handler;
    }

    public void connect() throws NetworkErrorException {
        if (session != null && session.isOpen()) {
            return;
        }

        try {
            session = container.connectToServer(this, config.build(), new URI(WS_URL));
            session.addMessageHandler(this);
        } catch (DeploymentException | IOException | URISyntaxException ignored) {
            throw new NetworkErrorException("Não foi possível estabelecer uma conexão com a Internet. Verifique sua conexão de rede e tente novamente.");
        }
    }

    public void disconnect() throws RequestFailedException {
        if (session == null || !session.isOpen()) {
            return;
        }

        try {
            session.close();
        } catch (IOException cause) {
            throw new RequestFailedException("Não foi possível fechar a conexão com o servidor.", cause);
        }
    }

    public void send(JSONObject message) throws RequestFailedException {
        if (session == null || !session.isOpen()) {
            return;
        }

        try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException cause) {
            throw new RequestFailedException("Não foi possível enviar a mensagem ao servidor.", cause);
        }
    }

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        handler.handleOpen();
    }

    @Override
    public void onClose(Session session, CloseReason reason) {
        if (reason.getCloseCode() == CloseReason.CloseCodes.NORMAL_CLOSURE) {
            handler.handleClose(reason);
        }

        // TODO: reconnect
    }

    @Override
    public void onMessage(String data) {
        try {
            JSONObject message = new JSONObject(data);

            handler.handleMessage(message.getString("event"), message.getJSONObject("data"));
        } catch (JSONException cause) {
            handler.handleError(new RequestFailedException("A mensagem recebida do servidor é inválida.", cause));
        }
    }

    @Override
    public void onError(Session session, Throwable cause) {
        handler.handleError(new RequestFailedException("Ops... Ocorreu um problema na conexão!", cause));
    }
}
