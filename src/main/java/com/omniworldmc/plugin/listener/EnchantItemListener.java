package com.omniworldmc.plugin.listener;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.lib.PowerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantItemListener implements Listener {

    OmniWorldMC plugin;

    public EnchantItemListener(OmniWorldMC plugin)
    {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority= EventPriority.LOW, ignoreCancelled=true)
    public void canEnchant(EnchantItemEvent event)
    {
        ItemStack item = event.getItem();
        if (!PowerUtils.isPowerTool(item)) {
            return;
        }
        if (!PowerUtils.checkEnchantPermission(event.getEnchanter(), item.getType())) {
            event.setCancelled(true);
        }
    }
}
