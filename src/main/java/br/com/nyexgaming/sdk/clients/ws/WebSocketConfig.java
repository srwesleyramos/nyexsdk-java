package br.com.nyexgaming.sdk.clients.ws;

import jakarta.websocket.ClientEndpointConfig;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WebSocketConfig extends ClientEndpointConfig.Configurator {

    private final String storeId;
    private final String serverId;

    public WebSocketConfig(String storeId, String serverId) {
        this.storeId = "Bearer " + storeId;
        this.serverId = "Bearer " + serverId;
    }

    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        headers.put("store-id-authorization", Collections.singletonList(this.storeId));
        headers.put("server-id-authorization", Collections.singletonList(this.serverId));
    }

    public ClientEndpointConfig build() {
        return ClientEndpointConfig.Builder.create().configurator(this).build();
    }

    public String storeId() {
        return storeId;
    }

    public String serverId() {
        return serverId;
    }
}
