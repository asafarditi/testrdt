package com.example.nexus_core.models.platform.enums;

public enum NavigationSourceEnum {
    UNKNOWN(0),
    NONE(1),
    INITIALIZATION(2),
    GPS(3),
    NAVGUARD(4),
    STATIC_POSITION(5),
    YNAV(6);

    private final int value;

    NavigationSourceEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
