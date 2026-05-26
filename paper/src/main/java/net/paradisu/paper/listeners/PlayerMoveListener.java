package net.paradisu.paper.listeners;

import lombok.AllArgsConstructor;
import net.paradisu.paper.ParadisuPaper;
import net.paradisu.paper.sync.PlayerRegionSync;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

@AllArgsConstructor
public class PlayerMoveListener implements Listener {
    private final ParadisuPaper paradisu;

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();

        if(from.getBlockX() == to.getBlockX() && from.getBlockY() == to.getBlockY() && from.getBlockZ() == to.getBlockZ()) return;
        new PlayerRegionSync(player, to);
    }
}
