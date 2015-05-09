package com.omniworldmc.plugin.listeners;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.api.item.Items;
import com.omniworldmc.plugin.util.Perms;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {

    private final OmniWorldMC plugin;

    public BlockListener(OmniWorldMC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        if (player.getItemInHand() == Items.donorFortunePick() || player.getItemInHand() == Items.donorPickSilk()) {
            if (block.getType().equals(Material.STONE) || block.getType().equals(Material.COBBLESTONE)) {
                if (player.hasPermission(Perms.OM_USE_VEIN_MINER)) {
                    int[] location = {0,0,0};
                    String locationWorld = "Eden";
                    location[0]=block.getLocation().getBlockX();
                    location[1]=block.getLocation().getBlockY();
                    location[2]=block.getLocation().getBlockZ();
                    locationWorld=block.getLocation().getWorld().getName();
                    String direction = player.getLocation().getDirection().toString();
                }
            }
        }
    }
}
