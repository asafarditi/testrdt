package com.example.nexus_core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Enables a simple in-memory broker and sets the destination prefixes
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Registers the /ws endpoint for WebSocket connections with SockJS fallback
        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://localhost:3000") // Allow frontend origin
                .withSockJS();
    }
}
