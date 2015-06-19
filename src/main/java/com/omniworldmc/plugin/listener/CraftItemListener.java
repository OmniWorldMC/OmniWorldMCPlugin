package com.omniworldmc.plugin.listener;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.lib.PowerUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftItemListener implements Listener {

    OmniWorldMC plugin;

    public CraftItemListener(OmniWorldMC plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority= EventPriority.LOW, ignoreCancelled=true)
    public void canCraft(CraftItemEvent event) {
        ItemStack resultItem = event.getRecipe().getResult();
        if (!PowerUtils.isPowerTool(resultItem)) {
            return;
        }
        if (!PowerUtils.checkCraftPermission((Player)event.getWhoClicked(), resultItem.getType())) {
            event.setCancelled(true);
        }
    }
}
