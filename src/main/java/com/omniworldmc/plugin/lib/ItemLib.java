package com.omniworldmc.plugin.lib;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemLib {

    public ItemStack excavator() {

        ItemStack excavator = new ItemStack(Material.DIAMOND_SPADE);
        ItemMeta meta = excavator.getItemMeta();

        meta.setDisplayName("Diamond Excavator");
    }
}
