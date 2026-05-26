package net.paradisu.paper.regionaudio;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.player.User;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Transition {
    public Transition(Player player, String oldRegion, String newRegion) {
        Data.of(player).transitioning(true);
        User user = PacketEvents.getAPI().getPlayerManager().getUser(player);

        new BukkitRunnable() {


            @Override
            public void run() {

            }
        };
    }
}
