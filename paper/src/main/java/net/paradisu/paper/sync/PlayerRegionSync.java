package net.paradisu.paper.sync;

import net.paradisu.paper.regionaudio.Data;
import net.paradisu.paper.regionaudio.Transition;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;

public class PlayerRegionSync {
    public PlayerRegionSync(Player player, Location location) {
        String currentRegion = "none";
        String lastRegion = Data.of(player).currentRegion();
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();
        ApplicableRegionSet locationRegions = query.getApplicableRegions(BukkitAdapter.adapt(location));

        for(ProtectedRegion region : locationRegions.getRegions()) {
            if(region.getId().startsWith("rs_")) {
                currentRegion = region.getId().substring(3);
                break;
            }
        }

        if(!currentRegion.equalsIgnoreCase(lastRegion)) {
            if(!lastRegion.equalsIgnoreCase("none")) Data.of(player).lastRegion(lastRegion);
            player.sendMessage("current region: " + currentRegion + " last region: " + lastRegion);
            Data.of(player).currentRegion(currentRegion);
            new Transition(player, lastRegion, currentRegion);
        }
    }
}
