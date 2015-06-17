package com.omniworldmc.plugin.crafting;

import com.omniworldmc.plugin.OmniWorldMC;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class CraftItemHammer {

    public OmniWorldMC plugin;
    public static String loreString = "Acts like the TC Hammer!";
    ItemStack DiamondHammer = new ItemStack(Material.DIAMOND_PICKAXE, 1);
    ShapedRecipe DiamondHammerRecipe;

    public CraftItemHammer(OmniWorldMC plugin) {
        this.plugin = plugin;

        modifyItemMeta();
        setRecipes();
        registerRecipes();
    }

    public void modifyItemMeta() {
        ItemMeta DiamondHammerMeta = this.DiamondHammer.getItemMeta();

        ArrayList<String> lore = new ArrayList();
        lore.add(loreString);

        DiamondHammerMeta.setDisplayName("Diamond Hammer");

        DiamondHammerMeta.setLore(lore);

        this.DiamondHammer.setItemMeta(DiamondHammerMeta);
    }

    public void setRecipes() {
        this.DiamondHammerRecipe = new ShapedRecipe(this.DiamondHammer);

        this.DiamondHammerRecipe.shape(new String[] { "mmm", "mim", "mmm" });
        this.DiamondHammerRecipe.setIngredient('m', Material.DIAMOND_BLOCK);
        this.DiamondHammerRecipe.setIngredient('i', Material.DIAMOND_PICKAXE);
    }

    public void registerRecipes() {
        this.plugin.getServer().addRecipe(this.DiamondHammerRecipe);
    }
}
