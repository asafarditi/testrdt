package com.example.nexus_core.models.platform.enums;

public enum GpsSourceVoterEnum {
    GPS_SOURCE_VOTER_DONT_CHANGE(0),
    GPS_SOURCE_VOTER_GPS(1),
    GPS_SOURCE_VOTER_ASIO(2),
    GPS_SOURCE_VOTER_YNAV(3),
    GPS_SOURCE_VOTER_AUTO_PRIO_GPS_SEC_ASIO(12),
    GPS_SOURCE_VOTER_AUTO_PRIO_GPS_SEC_YNAV(13),
    GPS_SOURCE_VOTER_AUTO_PRIO_ASIO_SEC_GPS(21),
    GPS_SOURCE_VOTER_AUTO_PRIO_YNAV_SEC_GPS(31);

    private final int value;

    GpsSourceVoterEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
