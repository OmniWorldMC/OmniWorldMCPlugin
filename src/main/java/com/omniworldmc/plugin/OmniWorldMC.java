package com.omniworldmc.plugin;

import com.omniworldmc.plugin.commands.CmdOm;
import com.omniworldmc.plugin.commands.CmdRage;
import com.omniworldmc.plugin.listeners.EnderBowListener;
import com.omniworldmc.plugin.util.Perms;
import com.omniworldmc.plugin.util.Recipes;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class OmniWorldMC extends JavaPlugin {

    boolean debugMode = this.getConfig().getBoolean("debug");
    boolean rageCommand = this.getConfig().getBoolean("rageCommand");

    @Override
    public void onEnable() {

        //Config Stuff
        this.getConfig().addDefault("debug", true);
        this.getConfig().addDefault("rageCommand", true);
        this.getConfig().options().copyDefaults(true);
        saveConfig();

        //Metrics
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
            if (debugMode == true) {
                getLogger().info("Stuff Loaded Successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("There was an oopsy! Submit an issue on git and copy paste the mumble jumble of words behind this message.");
        }

        try {
            this.getCommand("om").setExecutor(new CmdOm(this));
            if (rageCommand == true) {
                this.getCommand("rage").setExecutor(new CmdRage(this));
            }
            if (debugMode == true) {
                getLogger().info("Registered Commands.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().severe("Failed To Register Commands.");
        }

        //Register Listeners
        getServer().getPluginManager().registerEvents(new EnderBowListener(this), this);
        if (debugMode == true) {
            getLogger().info("Registered Events");
        }


        //Register Permissions
        Perms.init();
        if (debugMode == true) {
            getLogger().info("Loaded Permissions");
        }

        //Ender Bow
        Recipes recipes = new Recipes();
        recipes.init();
        if (debugMode == true) {
            getLogger().info("Registered Recipes");
        }

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {

        getLogger().info("Disabled");
    }
}
