package com.omniworldmc.plugin;

import com.omniworldmc.plugin.command.OmCommand;
import com.omniworldmc.plugin.handler.PlayerInteractHandler;
import com.omniworldmc.plugin.listener.EnderBowListener;
import com.omniworldmc.plugin.listener.PlayerListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OmniWorldMC extends JavaPlugin {

    PlayerInteractHandler playerInteractHandler;

    private final Logger logger;
    private PluginManager pm = this.getServer().getPluginManager();

    public OmniWorldMC(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void onEnable() {

        this.playerInteractHandler = new PlayerInteractHandler();

        this.pm.registerEvents(new EnderBowListener(this), this);
        this.pm.registerEvents(new PlayerListener(this), this);

        this.getCommand("om").setExecutor(new OmCommand(this));

        this.logger.log(Level.INFO, "Enabled");
    }

    @Override
    public void onDisable() {

        this.logger.log(Level.INFO, "Disabled");
    }

    public PlayerInteractHandler getPlayerInteractHandler() {
        return playerInteractHandler;
    }
}
