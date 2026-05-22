package net.paradisu.paper.config.configs;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@Accessors(fluent = true)
@Getter
@ConfigSerializable
public final class RegionAudioConfig {

    @Setting("sync-interval-seconds")
    private double syncIntervalSeconds = 5;

    @Setting("fade-time-seconds")
    private double fadeTimeSeconds = 2.5;

    @Setting("fade-height-blocks")
    private double fadeHeightBlocks = 18;

    @Setting("pitch-double")
    private double pitchMultiplier = 1.0;
}
