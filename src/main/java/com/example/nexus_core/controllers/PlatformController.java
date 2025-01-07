package com.example.nexus_core.controllers;

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
     * If the client ever sends /app/platformStatus messages,
     * we respond with the current platform statuses from the service.
     */
    @MessageMapping("/platformStatus")
    @SendTo("/topic/platformStatus")
    public PlatformStatusPayload handlePlatformStatus(PlatformStatusPayload payload) {
        return platformService.getPlatformStatus();
    }
}
