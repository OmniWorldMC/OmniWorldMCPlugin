package com.omniworldmc.plugin;

import com.omniworldmc.plugin.listeners.EnderBowListener;
import com.omniworldmc.plugin.util.Perms;
import com.omniworldmc.plugin.util.Recipes;
import org.bukkit.plugin.java.JavaPlugin;

public class OmniWorldMC extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new EnderBowListener(this), this);


        //Register Permissions
        Perms.init();

        //Ender Bow
        Recipes recipes = new Recipes();
        recipes.init();

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {

        getLogger().info("Disabled");
    }
}
