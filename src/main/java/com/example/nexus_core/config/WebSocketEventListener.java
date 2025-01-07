package com.example.nexus_core.config;

import com.example.nexus_core.models.platform.payloads.HandShakePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

/**
 * Sends a handshake message to /topic/handshake whenever a client subscribes
 * to that topic. This ensures the client receives the handshake right after subscription.
 */
@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @EventListener
    public void handleSessionSubscribeEvent(SessionSubscribeEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        String destination = sha.getDestination();
        logger.info("[WebSocketEventListener] SessionSubscribeEvent -> destination: {}", destination);

        // If the client subscribed to /topic/handshake, send handshake immediately
        if ("/topic/handshake".equals(destination)) {
            logger.info("[WebSocketEventListener] Sending handshake to /topic/handshake");
            var payload = new HandShakePayload("handShake", "Server handshake successful (subscribe-based)");
            messagingTemplate.convertAndSend("/topic/handshake", payload);
        }
    }
}
