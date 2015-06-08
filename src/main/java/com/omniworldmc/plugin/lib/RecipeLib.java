package com.omniworldmc.plugin.lib;

import com.omniworldmc.plugin.OmniWorldMC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RecipeLib {

    public void init(OmniWorldMC plugin) {
        plugin.getServer().addRecipe(enderBow());
        plugin.getServer().addRecipe(infiniteEnderBow());
    }

    public ShapedRecipe enderBow() {

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta meta = bow.getItemMeta();

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Teleportation I");

        meta.setDisplayName(ChatColor.AQUA + "Ender Bow");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 2, true);
        bow.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(bow);
        recipe.shape(new String[] {"EEE", "EBE", "EEE"});
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('B', Material.BOW);

        return recipe;
    }

    public ShapedRecipe infiniteEnderBow() {

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta meta = bow.getItemMeta();

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Teleportation II");

        meta.setDisplayName(ChatColor.GOLD + "Infinite Ender Bow");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 3, true);
        bow.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(bow);
        recipe.shape(new String[] {"EEE", "EBE", "EEE"});
        recipe.setIngredient('E', Material.EYE_OF_ENDER);
        recipe.setIngredient('B', Material.BOW);

        return recipe;
    }
}
