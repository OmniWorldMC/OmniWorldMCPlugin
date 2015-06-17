package com.omniworldmc.plugin.crafting;

import com.omniworldmc.plugin.OmniWorldMC;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CraftItemExcavator {
    public OmniWorldMC plugin;
    public static String loreString = "Acts like the TC Excavator!";
    ItemStack DiamondExcavator = new ItemStack(Material.DIAMOND_SPADE, 1);
    ShapedRecipe DiamondExcavatorRecipe;

    public CraftItemExcavator(OmniWorldMC plugin) {
        this.plugin = plugin;

        modifyItemMeta();
        setRecipes();
        registerRecipes();
    }

    public void modifyItemMeta() {
        ItemMeta DiamondExcavatorMeta = this.DiamondExcavator.getItemMeta();

        ArrayList<String> lore = new ArrayList();
        lore.add(loreString);

        DiamondExcavatorMeta.setDisplayName("Diamond Excavator");

        DiamondExcavatorMeta.setLore(lore);

        this.DiamondExcavator.setItemMeta(DiamondExcavatorMeta);
    }

    public void setRecipes() {
        this.DiamondExcavatorRecipe = new ShapedRecipe(this.DiamondExcavator);


        this.DiamondExcavatorRecipe.shape(new String[] { "mmm", "mim", "mmm" });
        this.DiamondExcavatorRecipe.setIngredient('m', Material.DIAMOND_BLOCK);
        this.DiamondExcavatorRecipe.setIngredient('i', Material.DIAMOND_SPADE);
    }

    public void registerRecipes() {
        this.plugin.getServer().addRecipe(this.DiamondExcavatorRecipe);
    }
}
