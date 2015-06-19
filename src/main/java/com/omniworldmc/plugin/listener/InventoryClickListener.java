package com.omniworldmc.plugin.listener;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.lib.PowerUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    OmniWorldMC plugin;

    public InventoryClickListener(OmniWorldMC plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority= EventPriority.LOW, ignoreCancelled=true)
    public void canEnchant(InventoryClickEvent event) {
        if (!(event.getInventory() instanceof AnvilInventory)) {
            return;
        }
        if (event.getSlotType() != InventoryType.SlotType.RESULT) {
            return;
        }
        ItemStack item = event.getInventory().getItem(0);
        ItemStack item2 = event.getInventory().getItem(1);
        if (!PowerUtils.isPowerTool(item)) {
            return;
        }
        if (item2 == null) {
            return;
        }
        if (item2.getType() != Material.ENCHANTED_BOOK) {
            switch (item2.getType()) {
                case LEATHER_HELMET:
                case LEATHER_LEGGINGS:
                case LEAVES:
                    return;
            }
            if (PowerUtils.isPowerTool(item2)) {
                if (!item.getEnchantments().isEmpty()) {}
            } else {
                event.setCancelled(true);
                return;
            }
        }
        if (!PowerUtils.checkEnchantPermission((Player) event.getWhoClicked(), item.getType())) {
            event.setCancelled(true);
        }
    }
}
