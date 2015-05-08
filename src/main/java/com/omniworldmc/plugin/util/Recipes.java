package com.omniworldmc.plugin.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Recipes {

    public void init() {

        Bukkit.getServer().addRecipe(enderBow());
        Bukkit.getServer().addRecipe(infiniteEnderBow());
    }

    public ShapedRecipe enderBow() {
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Teleportation I");

        bowMeta.setDisplayName(ChatColor.AQUA + "Ender Bow");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 2, true);
        bow.setItemMeta(bowMeta);

        ShapedRecipe recipe = new ShapedRecipe(bow);
        recipe.shape(new String[] {"EEE", "EBE", "EEE"});
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('B', Material.BOW);
        return recipe;
    }

    public ShapedRecipe infiniteEnderBow() {
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();

        List<String> lore = new ArrayList();
        lore.add(ChatColor.GRAY + "Teleportation II");

        bowMeta.setDisplayName(ChatColor.GOLD + "Infinite Ender Bow");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 3, true);
        bow.setItemMeta(bowMeta);

        ShapedRecipe recipe = new ShapedRecipe(bow);
        recipe.shape(new String[] { "EEE", "EBE", "EEE" });
        recipe.setIngredient('E', Material.EYE_OF_ENDER);
        recipe.setIngredient('B', Material.BOW);
        return recipe;
    }
}
