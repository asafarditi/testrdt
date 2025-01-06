package com.example.nexus_core.models.platform.payloads;

import com.example.nexus_core.models.platform.domain.PlatformStatus;

import java.util.List;

public class PlatformStatusPayload {
    private String type;
    private List<PlatformStatus> platforms;

    public PlatformStatusPayload() {}

    public PlatformStatusPayload(String type, List<PlatformStatus> platforms) {
        this.type = type;
        this.platforms = platforms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PlatformStatus> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<PlatformStatus> platforms) {
        this.platforms = platforms;
    }
}
