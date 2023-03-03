package br.com.nyexgaming.sdk;

import jakarta.websocket.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class NyexWS extends Endpoint {

    private final WebSocketContainer container;

    private Session session;

    public NyexWS() throws URISyntaxException, DeploymentException, IOException {
        this.container = ContainerProvider.getWebSocketContainer();
        this.container.connectToServer(this, new URI("wss://socketsbay.com/wss/v2/1/demo/"));

        this.sendMessage("salve rapaz");
    }

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        this.session = session;

        this.session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String string) {
                System.out.println(string);
            }
        });
    }

    public void sendMessage(String text) {
        try {
            this.session.getBasicRemote().sendText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
