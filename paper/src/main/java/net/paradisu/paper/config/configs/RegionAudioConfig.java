package net.paradisu.paper.config.configs;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@Accessors(fluent = true)
@Getter
@ConfigSerializable
public final class RegionAudioConfig {

    @Comment("(in seconds, default 6.0) Length of audio snippets. Longer sync interval = longer switching, less possible noise. Shorter sync interval = shorter switching, more possible noise.")
    @Setting("sync-interval")
    private double syncIntervalSeconds = 6.0;

    @Comment("(in seconds, default 2.5) Time to fade in/out separately.")
    @Setting("fade-time")
    private double fadeTimeSeconds = 2.5;

    @Comment("(in blocks, default 18.0) Maximum height to fade to and switch at. Default should be fine, adjust if heard farther away or not heard nearby.")
    @Setting("fade-height")
    private double fadeHeightBlocks = 18.0;

    @Comment("(multiplier, default 1.0) Pitch multiplier, just for fun!")
    @Setting("pitch")
    private double pitchMultiplier = 1.0;
}
