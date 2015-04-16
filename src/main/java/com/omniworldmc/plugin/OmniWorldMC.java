package com.omniworldmc.plugin;

import com.omniworldmc.plugin.commands.CMDOM;
import com.omniworldmc.plugin.commands.CMDRage;
import com.omniworldmc.plugin.listeners.EnderBowListener;
import com.omniworldmc.plugin.util.Perms;
import com.omniworldmc.plugin.util.Recipes;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class OmniWorldMC extends JavaPlugin {

    @Override
    public void onEnable() {

        //Metrics
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("There was an oopsy! Submit an issue on git and copy paste the mumble jumble of words behind this message.");
        }

        //Register CMD's
        this.getCommand("om").setExecutor(new CMDOM(this));
        this.getCommand("rage").setExecutor(new CMDRage(this));

        //Register Listeners
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
