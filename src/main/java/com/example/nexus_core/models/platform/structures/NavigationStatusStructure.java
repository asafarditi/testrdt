package com.example.nexus_core.models.platform.structures;

import com.example.nexus_core.models.platform.enums.AnchorSourceEnum;
import com.example.nexus_core.models.platform.enums.GpsSourceVoterEnum;
import com.example.nexus_core.models.platform.enums.NavigationSourceEnum;

public class NavigationStatusStructure {
    private NavigationSourceEnum navigation_source;
    private AnchorSourceEnum anchor_source;
    private float estimated_delta = 0;
    private float slam_quality = 0;
    private boolean gps_jam = false;
    private boolean gps_spoof = false;
    private GpsSourceVoterEnum gps_source_voter_mode;

    public NavigationStatusStructure() {}

    public NavigationStatusStructure(NavigationSourceEnum navigation_source, AnchorSourceEnum anchor_source,
                                     float estimated_delta, float slam_quality, boolean gps_jam,
                                     boolean gps_spoof, GpsSourceVoterEnum gps_source_voter_mode) {
        this.navigation_source = navigation_source;
        this.anchor_source = anchor_source;
        this.estimated_delta = estimated_delta;
        this.slam_quality = slam_quality;
        this.gps_jam = gps_jam;
        this.gps_spoof = gps_spoof;
        this.gps_source_voter_mode = gps_source_voter_mode;
    }

    public NavigationSourceEnum getNavigation_source() {
        return navigation_source;
    }

    public void setNavigation_source(NavigationSourceEnum navigation_source) {
        this.navigation_source = navigation_source;
    }

    public AnchorSourceEnum getAnchor_source() {
        return anchor_source;
    }

    public void setAnchor_source(AnchorSourceEnum anchor_source) {
        this.anchor_source = anchor_source;
    }

    public float getEstimated_delta() {
        return estimated_delta;
    }

    public void setEstimated_delta(float estimated_delta) {
        this.estimated_delta = estimated_delta;
    }

    public float getSlam_quality() {
        return slam_quality;
    }

    public void setSlam_quality(float slam_quality) {
        this.slam_quality = slam_quality;
    }

    public boolean isGps_jam() {
        return gps_jam;
    }

    public void setGps_jam(boolean gps_jam) {
        this.gps_jam = gps_jam;
    }

    public boolean isGps_spoof() {
        return gps_spoof;
    }

    public void setGps_spoof(boolean gps_spoof) {
        this.gps_spoof = gps_spoof;
    }

    public GpsSourceVoterEnum getGps_source_voter_mode() {
        return gps_source_voter_mode;
    }

    public void setGps_source_voter_mode(GpsSourceVoterEnum gps_source_voter_mode) {
        this.gps_source_voter_mode = gps_source_voter_mode;
    }
}
