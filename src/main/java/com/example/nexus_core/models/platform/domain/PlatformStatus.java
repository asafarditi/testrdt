package com.example.nexus_core.models.platform.domain;

import com.example.nexus_core.models.platform.enums.FlightModeEnum;
import com.example.nexus_core.models.platform.enums.PlatformCategoryEnum;
import com.example.nexus_core.models.platform.structures.BatteryStatusStructure;
import com.example.nexus_core.models.platform.structures.PositionStructure;
import com.example.nexus_core.models.platform.structures.GeoPointStructure;
import com.example.nexus_core.models.platform.structures.NavigationStatusStructure;

/**
 * Represents the core status data of a platform (e.g., a drone).
 */
public class PlatformStatus {
    private int platform_id;
    private FlightModeEnum flight_mode;
    private PositionStructure position;
    private int communication_status;
    private BatteryStatusStructure battery_status;
    private GeoPointStructure home_position;
    private PlatformCategoryEnum platform_category;
    private NavigationStatusStructure navigation_status;

    public PlatformStatus() {}

    public PlatformStatus(
            int platform_id,
            FlightModeEnum flight_mode,
            PositionStructure position,
            int communication_status,
            BatteryStatusStructure battery_status,
            GeoPointStructure home_position,
            PlatformCategoryEnum platform_category,
            NavigationStatusStructure navigation_status
    ) {
        this.platform_id = platform_id;
        this.flight_mode = flight_mode;
        this.position = position;
        this.communication_status = communication_status;
        this.battery_status = battery_status;
        this.home_position = home_position;
        this.platform_category = platform_category;
        this.navigation_status = navigation_status;
    }

    public int getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(int platform_id) {
        this.platform_id = platform_id;
    }

    public FlightModeEnum getFlight_mode() {
        return flight_mode;
    }

    public void setFlight_mode(FlightModeEnum flight_mode) {
        this.flight_mode = flight_mode;
    }

    public PositionStructure getPosition() {
        return position;
    }

    public void setPosition(PositionStructure position) {
        this.position = position;
    }

    public int getCommunication_status() {
        return communication_status;
    }

    public void setCommunication_status(int communication_status) {
        this.communication_status = communication_status;
    }

    public BatteryStatusStructure getBattery_status() {
        return battery_status;
    }

    public void setBattery_status(BatteryStatusStructure battery_status) {
        this.battery_status = battery_status;
    }

    public GeoPointStructure getHome_position() {
        return home_position;
    }

    public void setHome_position(GeoPointStructure home_position) {
        this.home_position = home_position;
    }

    public PlatformCategoryEnum getPlatform_category() {
        return platform_category;
    }

    public void setPlatform_category(PlatformCategoryEnum platform_category) {
        this.platform_category = platform_category;
    }

    public NavigationStatusStructure getNavigation_status() {
        return navigation_status;
    }

    public void setNavigation_status(NavigationStatusStructure navigation_status) {
        this.navigation_status = navigation_status;
    }
}
