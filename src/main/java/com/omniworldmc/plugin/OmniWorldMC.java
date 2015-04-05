package com.omniworldmc.plugin;

import com.omniworldmc.plugin.commands.CMDOM;
import com.omniworldmc.plugin.commands.CMDRage;
import com.omniworldmc.plugin.listeners.EnderBowListener;
import com.omniworldmc.plugin.util.Perms;
import com.omniworldmc.plugin.util.Recipes;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class OmniWorldMC extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pm = getServer().getPluginManager();

        //Metrics
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("Failed To Submit Metrics, Tell Chris about this.");
        }

        //Register CMD's
        this.getCommand("om").setExecutor(new CMDOM(this));
        this.getCommand("rage").setExecutor(new CMDRage(this));

        //Register Listeners
        getServer().getPluginManager().registerEvents(new EnderBowListener(this), this);


        //Register Permissions
        pm.addPermission(Perms.OM);
        pm.addPermission(Perms.OM_HELP);
        pm.addPermission(Perms.OM_RELOAD);
        pm.addPermission(Perms.RAGE);
        pm.addPermission(Perms.USE_ENDERBOW);

        //Ender Bow
        Recipes recipes = new Recipes();
        getServer().addRecipe(recipes.enderBow());
        getServer().addRecipe(recipes.infiniteEnderBow());

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {

        getLogger().info("Disabled");
    }
}
