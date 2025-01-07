package com.example.nexus_core.models.platform.structures;

public class PositionStructure {
    private GeoPointStructure global_position;
    private float relative_altitude;
    private float yaw;
    private float pitch;
    private float roll;

    public PositionStructure() {}

    public PositionStructure(GeoPointStructure global_position, float relative_altitude, float yaw, float pitch, float roll) {
        this.global_position = global_position;
        this.relative_altitude = relative_altitude;
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
    }

    public GeoPointStructure getGlobal_position() {
        return global_position;
    }

    public void setGlobal_position(GeoPointStructure global_position) {
        this.global_position = global_position;
    }

    public float getRelative_altitude() {
        return relative_altitude;
    }

    public void setRelative_altitude(float relative_altitude) {
        this.relative_altitude = relative_altitude;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getRoll() {
        return roll;
    }

    public void setRoll(float roll) {
        this.roll = roll;
    }
}
