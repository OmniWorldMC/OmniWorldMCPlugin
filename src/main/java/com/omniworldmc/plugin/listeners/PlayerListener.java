package com.omniworldmc.plugin.listeners;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.api.chat.Returns;
import com.omniworldmc.plugin.util.Perms;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener {

    public PlayerListener(OmniWorldMC plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getEntity().hasPermission(Perms.OM_SHOW_DEATH_LOC)) {
                Player player = event.getEntity();
                int[] playerDeathLoc = {0, 0, 0};
                String deathWorld;
                playerDeathLoc[0] = player.getLocation().getBlockX();
                playerDeathLoc[1] = player.getLocation().getBlockY();
                playerDeathLoc[2] = player.getLocation().getBlockZ();
                deathWorld = player.getLocation().getWorld().getName();
                Returns.deathLocMessage(player, playerDeathLoc[0], playerDeathLoc[1], playerDeathLoc[2], deathWorld);
            }
        }
    }
}
