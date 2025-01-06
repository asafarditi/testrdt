package com.example.nexus_core.services;

import com.example.nexus_core.models.platform.domain.PlatformStatus;
import com.example.nexus_core.models.platform.enums.FlightModeEnum;
import com.example.nexus_core.models.platform.enums.PlatformCategoryEnum;
import com.example.nexus_core.models.platform.payloads.PlatformStatusPayload;
import com.example.nexus_core.models.platform.structures.BatteryStatusStructure;
import com.example.nexus_core.models.platform.structures.GeoPointStructure;
import com.example.nexus_core.models.platform.structures.NavigationStatusStructure;
import com.example.nexus_core.models.platform.enums.NavigationSourceEnum;
import com.example.nexus_core.models.platform.enums.AnchorSourceEnum;
import com.example.nexus_core.models.platform.enums.GpsSourceVoterEnum;
import com.example.nexus_core.models.platform.structures.PositionStructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PlatformService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final List<PlatformStatus> platforms = new ArrayList<>();
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        // Example initial data
        PlatformStatus platform1 = new PlatformStatus(
                1,
                FlightModeEnum.Guided,
                new PositionStructure(
                        new GeoPointStructure(32.3215, 34.8532, 15.0),
                        100.0f,
                        0.0f,
                        0.0f,
                        0.0f
                ),
                1,
                new BatteryStatusStructure(12.5f, 1.5f, 80.0f),
                new GeoPointStructure(32.3215, 34.8532, 15.0),
                PlatformCategoryEnum.QUAD_COPTER,
                new NavigationStatusStructure(
                        NavigationSourceEnum.GPS,
                        AnchorSourceEnum.GPS,
                        0.0f,
                        0.0f,
                        false,
                        false,
                        GpsSourceVoterEnum.GPS_SOURCE_VOTER_GPS
                )
        );

        PlatformStatus platform2 = new PlatformStatus(
                2,
                FlightModeEnum.Guided,
                new PositionStructure(
                        new GeoPointStructure(32.3220, 34.8537, 20.0),
                        120.0f,
                        0.0f,
                        0.0f,
                        0.0f
                ),
                1,
                new BatteryStatusStructure(12.0f, 1.2f, 90.0f),
                new GeoPointStructure(32.3220, 34.8537, 20.0),
                PlatformCategoryEnum.QUAD_COPTER,
                new NavigationStatusStructure(
                        NavigationSourceEnum.GPS,
                        AnchorSourceEnum.GPS,
                        0.0f,
                        0.0f,
                        false,
                        false,
                        GpsSourceVoterEnum.GPS_SOURCE_VOTER_GPS
                )
        );

        platforms.add(platform1);
        platforms.add(platform2);
    }

    @Scheduled(fixedRate = 1000)
    public void updateAndBroadcast() {
        for (PlatformStatus p : platforms) {
            movePlatformRandomly(p);
            degradeBattery(p);
        }
        messagingTemplate.convertAndSend(
                "/topic/platformStatus",
                new PlatformStatusPayload("platformStatus", platforms)
        );
    }

    private void movePlatformRandomly(PlatformStatus platform) {
        float speedMax = 12.0f;
        float speed = speedMax * random.nextFloat();
        float angle = (float) (2.0f * Math.PI * random.nextFloat());

        float deltaLat = (float) (speed * Math.cos(angle) * 0.000009);
        float deltaLng = (float) (speed * Math.sin(angle) * 0.000009);

        var gp = platform.getPosition().getGlobal_position();
        float newLat = (float) (gp.getLatitude() + deltaLat);
        float newLng = (float) (gp.getLongitude() + deltaLng);
        float newAlt = (float) (gp.getAltitude() + random.nextFloat() * 2.0f - 1.0f);

        gp.setLatitude(newLat);
        gp.setLongitude(newLng);
        gp.setAltitude(Math.max(0, newAlt));

        float relAlt = platform.getPosition().getRelative_altitude();
        float relAltChange = (speed / 2.0f) * (random.nextFloat() - 0.5f);
        float newRelAlt = relAlt + relAltChange;
        platform.getPosition().setRelative_altitude(Math.max(0, newRelAlt));
    }

    private void degradeBattery(PlatformStatus platform) {
        if (random.nextInt(21) == 0) { // randomly degrade battery by 1% within 0-20 seconds
            var battery = platform.getBattery_status();
            float newPerc = (float) (battery.getPercentage() - 1.0f);
            battery.setPercentage(Math.max(0, newPerc));
        }
    }

    public PlatformStatusPayload getPlatformStatus() {
        return new PlatformStatusPayload("platformStatus", platforms);
    }
}
