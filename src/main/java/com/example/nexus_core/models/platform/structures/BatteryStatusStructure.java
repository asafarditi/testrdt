package com.example.nexus_core.models.platform.structures;

public class BatteryStatusStructure {
    private double voltage;
    private double current;
    private double percentage;

    public BatteryStatusStructure() {}

    public BatteryStatusStructure(double voltage, double current, double percentage) {
        this.voltage = voltage;
        this.current = current;
        this.percentage = percentage;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
