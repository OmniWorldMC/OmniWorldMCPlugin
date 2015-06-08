package com.omniworldmc.plugin.listener;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.lib.ChatLib;
import com.omniworldmc.plugin.lib.PermLib;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener {

    private final OmniWorldMC plugin;

    public PlayerListener(OmniWorldMC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity().hasPermission(PermLib.SHOW_DEATH_LOCATION)) {
            Player player = event.getEntity();
            int[] deathLoc = {0,0,0};
            String deathWorld = "";
            deathLoc[0] = player.getLocation().getBlockX();
            deathLoc[1] = player.getLocation().getBlockY();
            deathLoc[2] = player.getLocation().getBlockZ();
            deathWorld = player.getLocation().getWorld().getName();
            ChatLib.deathLocMessage(player, deathLoc[0], deathLoc[1], deathLoc[2], deathWorld);
        }
    }
}
