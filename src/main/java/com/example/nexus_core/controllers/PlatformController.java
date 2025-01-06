package com.example.nexus_core.controllers;

import com.example.nexus_core.models.platform.payloads.HandShakePayload;
import com.example.nexus_core.models.platform.payloads.PlatformStatusPayload;
import com.example.nexus_core.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    /**
     * Handles HandShakeMessage sent by the client upon connecting.
     * Destination: /app/handshake
     * Response: /topic/handshake
     */
    @MessageMapping("/handshake")
    @SendTo("/topic/handshake")
    public HandShakePayload handleHandshake(HandShakePayload payload) {
        // For simplicity, echo back the received data with a confirmation message
        return new HandShakePayload("handShake", "Handshake successful");
    }

    /**
     * Handles PlatformStatusMessage sent by the server to update platform statuses.
     * Destination: /app/platformStatus
     * Response: /topic/platformStatus
     */
    @MessageMapping("/platformStatus")
    @SendTo("/topic/platformStatus")
    public PlatformStatusPayload handlePlatformStatus(PlatformStatusPayload payload) {
        // Retrieve the current status of all platforms
        return platformService.getPlatformStatus();
    }
}
