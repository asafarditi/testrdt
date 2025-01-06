package com.example.nexus_core.models.platform.payloads;

public class HandShakePayload {
    private String type;
    private String data;

    public HandShakePayload() {}

    public HandShakePayload(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
