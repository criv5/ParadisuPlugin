package net.paradisu.paper.regionaudio;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Accessors(fluent = true)
public class Data {
    private static final Map<UUID, Data> playerData = new HashMap<>();

    private Player player;
    private boolean transitioning;
    private double height;
    private State state;
    private boolean debug;
    private float volume;
    private String currentRegion;
    private String lastRegion;

    public enum State {
        INACTIVE,
        FADEIN,
        SWITCH,
        FADEOUT
    }

    public Data(Player player) {
        this.player = player;
        this.transitioning = false;
        this.height = 0;
        this.state = State.INACTIVE;
        this.debug = false;
        this.volume = 1;
        this.currentRegion = "none";
        this.lastRegion = "none";

        playerData.put(player.getUniqueId(), this);
    }

    public static Data of(Player player) {
        return playerData.get(player.getUniqueId());
    }

    public static void create(Player player) {
        new Data(player);
    }

    public static void delete(Player player) {
        playerData.remove(player.getUniqueId());
    }

    public static boolean exists(Player player) {
        return playerData.containsKey(player.getUniqueId());
    }
}