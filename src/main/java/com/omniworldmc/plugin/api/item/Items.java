package com.omniworldmc.plugin.api.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {

    public static ItemStack donorFortunePick() {

        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Donators Pick");
        meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack donorPickSilk() {

        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Donators Pick");
        meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        item.setItemMeta(meta);

        return item;
    }
}
