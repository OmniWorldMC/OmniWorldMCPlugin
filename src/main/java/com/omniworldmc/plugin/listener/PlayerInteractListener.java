package com.omniworldmc.plugin.listener;

import com.omniworldmc.plugin.OmniWorldMC;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerInteractListener implements Listener {

    public OmniWorldMC plugin;
    private HashMap<UUID, BlockFace> faces = new HashMap<UUID, BlockFace>();

    public PlayerInteractListener(OmniWorldMC plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void saveBlockFace(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        BlockFace blockFace = event.getBlockFace();
        if ((player != null) && (blockFace != null)) {
            UUID uuid = player.getUniqueId();
            this.faces.put(uuid, blockFace);
        }
    }

    public BlockFace getBlockFaceByUUID(UUID uuid) {
        return (BlockFace) this.faces.get(uuid);
    }
}
