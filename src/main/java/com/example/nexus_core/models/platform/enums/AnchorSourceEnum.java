package com.example.nexus_core.models.platform.enums;

public enum AnchorSourceEnum {
    NONE(0),
    GPS(1),
    NAVGUARD(2),
    MAGICBOX(3),
    SLAMBIT(4),
    APS(5),
    MANUAL(6);

    private final int value;

    AnchorSourceEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
